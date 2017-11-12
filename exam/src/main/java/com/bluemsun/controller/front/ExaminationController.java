package com.bluemsun.controller.front;

import com.bluemsun.common.core.Pages;
import com.bluemsun.common.entitys.*;
import com.bluemsun.common.vo.ExaminationVo;
import com.bluemsun.common.vo.FinishExaminationVo;
import com.bluemsun.common.vo.QuestionVo;
import com.bluemsun.common.vo.QuestionsVo;
import com.bluemsun.service.Examination.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/9/19 19:38
 */
@Controller
@RequestMapping("/ExaminationController")
public class ExaminationController {

    @Autowired
    private ExaminationService examinationService;

    @Autowired
    private EditionService editionService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private QuestionsService questionsService;

    @Autowired
    private FinishExaminationService finishExaminationService;

    @Autowired
    private QuestionsTypeService questionsTypeService;

    @Autowired
    private FinishAnswerService finishAnswerService;


    /**
    * @Description: 返回首页
    * @Date: 2017/10/9 20:16
    */
    @RequestMapping("/toIndex")
    public String toIndex() {
        return Pages.FRONTINDEX;
    }


    /**
    * @Description: 查询出所有的册，返回json
    * @Date: 2017/9/19 19:41
    */
    @RequestMapping("/edition")
    @ResponseBody
    public List<Edition> selectAllEdition() {
        List<Edition> list = editionService.selectAllEdtion();
        return list;
    }


    /**
    * @Description: 根据册查询出单元，返回json
    * @Date: 2017/9/19 20:49
    */
    @RequestMapping("/unit")
    @ResponseBody
    public List<Unit> selectUnitByEdition(String editionId) {
        List<Unit> list = unitService.selectAllUnit(editionId);
        return list;
    }


    /**
    * @Description: 根据单元查询出试卷，返回json
    * @Date: 2017/9/19 20:59
    */
    @RequestMapping("/findExamination")
    @ResponseBody
    public List<ExaminationVo> selectExaminationByUnit(String unitId) {
        List<ExaminationVo> list = examinationService.selectAllExamination(unitId);
        return list;
    }


    /**
    * @Description: 根据试卷id查询出试题，并且显示到前台做题页面
    * @Date: 2017/9/23 18:01
    */
    @RequestMapping("/getExamination")
    @ResponseBody
    public List<QuestionsVo> getExamination(String examinationId, HttpSession session) {
        ExaminationVo examinationVo = examinationService.selectExamination(examinationId);
        session.setAttribute("examinationVo", examinationVo);
        List<QuestionsVo> list = new ArrayList<QuestionsVo>();
        for(int i = 0; i < examinationVo.getQuestionsList().length; i++) {
            list.add(questionsService.selectQuestionsById(examinationVo.getQuestionsList()[i], null));
        }
        return list;
    }


    /**
    * @Description: 跳转到做题的页面
    * @Date: 2017/9/28 14:04
    */
    @RequestMapping("/toExamination")
    public String toExamination(String examinationId, HttpServletRequest request) {
        request.setAttribute("examinationId", examinationId);
        return Pages.FRONTEXAM;
    }


    /**
    * @Description: 接收从前台传来的json数据
    * @Date: 2017/9/29 12:14
    */
    @RequestMapping("/getAnswer")
    @ResponseBody
    public void getAnswer(@RequestParam String list, HttpSession session) {
        JSONArray jsonArray = JSONArray.fromObject(list);
        List<QuestionsVo> questionslist = (List<QuestionsVo>)JSONArray.toCollection(jsonArray, QuestionsVo.class);

        ExaminationVo examinationVo = (ExaminationVo)session.getAttribute("examinationVo");
        Student student = (Student)session.getAttribute("student");
        FinishExamination finishExamination = new FinishExamination(student.getId(), examinationVo.getId(), examinationVo.getUnitId());
        String finishExamId = finishExaminationService.addFinishExamination(finishExamination);
        session.removeAttribute("examinationVo");
        // 完成的试卷信息已存贮完毕

        int questionsLength = questionslist.size();
        int totalMark = 0;
        for(int i = 0; i < questionsLength; i++) {
            List<QuestionVo> questionVoList = questionslist.get(i).getQuestionList();
            // 判断一下是主观题还是客观题，客观题只有选择和完型
            int questionLength = questionVoList.size();
            QuestionsType questionsType = questionsTypeService.selectById(questionslist.get(i).getId());

            // 如果是客观的话
            if(questionsType.getQuestionsTypeName().equals("选择题") || questionsType.getQuestionsTypeName().equals("完型填空")) {
                for(int j = 0; j < questionLength; j++) {
                    JSONObject jsonObject = JSONObject.fromObject(questionVoList.get(j));
                    QuestionVo questionVo = (QuestionVo)JSONObject.toBean(jsonObject, QuestionVo.class);

                    // 计算分数
                    int mark = 0;
                    if(questionVo.getStudentAnswer().equals(questionVo.getQuestionAnswer())) {
                        mark = questionVo.getQuestionMark();
                    }
                    totalMark += mark;
                    FinishAnswer finishAnswer = new FinishAnswer();
                    finishAnswer.setFinishExaminationId(finishExamId);
                    finishAnswer.setQuestionId(questionVo.getId());
                    finishAnswer.setFinishAnswerContent(questionVo.getStudentAnswer());
                    finishAnswer.setFinishAnswerMark(mark);
                    finishAnswerService.addFinishAnswer(finishAnswer);
                }
            }else {
                for(int j = 0; j < questionLength; j++) {
                    JSONObject jsonObject = JSONObject.fromObject(questionVoList.get(j));
                    QuestionVo questionVo = (QuestionVo)JSONObject.toBean(jsonObject, QuestionVo.class);

                    FinishAnswer finishAnswer = new FinishAnswer();
                    finishAnswer.setFinishExaminationId(finishExamId);
                    finishAnswer.setQuestionId(questionVo.getId());
                    finishAnswer.setFinishAnswerContent(questionVo.getStudentAnswer());
                    finishAnswerService.addFinishAnswer(finishAnswer);
                }
            }
        }
        finishExaminationService.updateMark(totalMark, finishExamId);
    }


    /**
    * @Description: 准备个人中心页的内容
    * @Date: 2017/10/9 20:12
    */
    @RequestMapping("getPersonal")
    @ResponseBody
    public List getPersonal(HttpSession session) {
        List<Object> list = new ArrayList<Object>();
        list.add(session.getAttribute("student"));
        String studentId = ((Student)session.getAttribute("student")).getId();
        List<FinishExaminationVo> examList = finishExaminationService.selectFromStudent(studentId);
        for(int i = 0; i < examList.size(); i++) {
            Date date = examList.get(i).getFinishTime();
            String dfm = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(dfm);
            String dateFormat = sdf.format(date);
            examList.get(i).setDateFormat(dateFormat);
        }
        list.add(examList);
        return list;
    }


    /**
     * @Description: 学生查阅自己的试卷
     * @Date: 2017/10/15 13:50
     */
    @RequestMapping("getMyPaper")
    @ResponseBody
    public List<QuestionsVo> getStudentPaper(String examinationId, String id) {
        ExaminationVo examinationVo = examinationService.selectExamination(examinationId);
        List<QuestionsVo> list = new ArrayList<QuestionsVo>();
        for(int i = 0; i < examinationVo.getQuestionsList().length; i++) {
            list.add(questionsService.selectQuestionsById(examinationVo.getQuestionsList()[i], id));
        }
        return list;
    }

}
