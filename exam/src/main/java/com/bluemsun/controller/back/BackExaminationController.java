package com.bluemsun.controller.back;

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

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/10/12 17:12
 */
@Controller
@RequestMapping("/backExaminationController")
public class BackExaminationController {


    @Autowired
    private EditionService editionService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private QuestionsService questionsService;

    @Autowired
    private ExaminationService examinationService;

    @Autowired
    private FinishExaminationService finishExaminationService;

    @Autowired
    private QuestionsTypeService questionsTypeService;

    @Autowired
    private FinishAnswerService finishAnswerService;


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
    * @Description: 获取老师出的新题
    * @Date: 2017/10/12 17:27
    */
    @RequestMapping("/getNewQuestions")
    @ResponseBody
    public void getNewQuestions(@RequestParam  String list) {
        JSONArray jsonArray = JSONArray.fromObject(list);
        List<QuestionsVo> questionslist = (List<QuestionsVo>)JSONArray.toCollection(jsonArray, QuestionsVo.class);
        QuestionsVo questionsVo = questionslist.get(0);

        JSONArray jsonArray1 = JSONArray.fromObject(questionsVo.getQuestionList());
        List<Question> questionList = (List<Question>)JSONArray.toCollection(jsonArray1, Question.class);

        questionsService.addQuestions(questionsVo, questionList);

    }


    /**
    * @Description: 获取出卷时，选择题型后，显示出来的所有对应大题
    * @Date: 2017/10/13 14:35
    */
    @RequestMapping("getQuestionsByType")
    @ResponseBody
    public List<QuestionsVo> getQuestionsByType(String unitId, String questionsTypeId) {
        List<QuestionsVo> list = questionsService.selectQuestionsByUnitAndType(unitId, questionsTypeId);
        return list;
    }


    /**
    * @Description: 添加试卷
    * @Date: 2017/10/13 19:56
    */
    @RequestMapping("addPaper")
    @ResponseBody
    public void addPaper(@RequestParam String list) {
//        JSONArray jsonArray = JSONArray.fromObject(list);
//        Examination examination = (Examination)JSONArray.toCollection(jsonArray, Examination.class);
        JSONObject jsonObject = JSONObject.fromObject(list);
        Examination examination = (Examination)JSONObject.toBean(jsonObject, Examination.class);

        examinationService.addExamination(examination);
    }


    /**
    * @Description: 查看老师属于那一册
    * @Date: 2017/10/15 12:38
    */
    @RequestMapping("teacherEdition")
    @ResponseBody
    public String teacherEdition(HttpSession session) {
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        String editionId = teacher.getTeacherEdition();
        return editionId;
    }


    /**
    * @Description: 根据已判过和未判过，还有单元去查询试卷
    * @Date: 2017/10/15 12:59
    */
    @RequestMapping("getCheckPaper")
    @ResponseBody
    public List<FinishExaminationVo> getCheckPaper(String unitId, String finishAlready, HttpSession session) {
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        List<FinishExaminationVo> list = finishExaminationService.selectFromTeacher(teacher.getTeacherEdition(), finishAlready, unitId);
        for(int i = 0; i < list.size(); i++) {
            Date date = list.get(i).getFinishTime();
            String dfm = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(dfm);
            String dateFormat = sdf.format(date);
            list.get(i).setDateFormat(dateFormat);
        }
        return list;
    }


    /**
    * @Description: 获取该判的试卷的数据
    * @Date: 2017/10/15 13:50
    */
    @RequestMapping("getStudentPaper")
    @ResponseBody
    public List<QuestionsVo> getStudentPaper(String examinationId, String id, HttpSession session) {
        ExaminationVo examinationVo = examinationService.selectExamination(examinationId);
        session.setAttribute("finishExaminationId", id);
        List<QuestionsVo> list = new ArrayList<QuestionsVo>();
        for(int i = 0; i < examinationVo.getQuestionsList().length; i++) {
            list.add(questionsService.selectQuestionsById(examinationVo.getQuestionsList()[i], id));
        }
        return list;
    }


    /**
    * @Description: 老师判完试卷
    * @Date: 2017/10/15 14:06
    */
    @RequestMapping("judgeOk")
    @ResponseBody
    public void judgeOk(String list, HttpSession session) {
        JSONArray jsonArray = JSONArray.fromObject(list);
        List<QuestionsVo> questionslist = (List<QuestionsVo>)JSONArray.toCollection(jsonArray, QuestionsVo.class);
        String finishExamId = (String)session.getAttribute("finishExaminationId");
        finishExaminationService.updateFinishExamination(finishExamId);
        FinishExaminationVo finishExaminationVo = finishExaminationService.selectFinExamById(finishExamId);
        int totalMark = finishExaminationVo.getFinishMark();

        int questionsLength = questionslist.size();
        for(int i = 0; i < questionsLength; i++) {
            List<QuestionVo> questionVoList = questionslist.get(i).getQuestionList();
            // 判断一下是主观题还是客观题，客观题只有选择和完型
            int questionLength = questionVoList.size();
            QuestionsType questionsType = questionsTypeService.selectById(questionslist.get(i).getId());

            // 如果是客观的话
            if(questionsType.getQuestionsTypeName().equals("选择题") || questionsType.getQuestionsTypeName().equals("完型填空")) {
                continue;
            }else {
                for(int j = 0; j < questionLength; j++) {
                    JSONObject jsonObject = JSONObject.fromObject(questionVoList.get(j));
                    QuestionVo questionVo = (QuestionVo)JSONObject.toBean(jsonObject, QuestionVo.class);

                    int mark = questionVo.getStudentMark();
                    totalMark += mark;

                    String finishAnsId = questionVo.getFinishAnswer().getId();

                    finishAnswerService.updateMark(finishAnsId, mark);
                }
            }
        }
        finishExaminationService.updateMark(totalMark, finishExamId);
    }


    @RequestMapping("deleteQuestions")
    public void deleteQuestions(String list) {
        questionsService.deleteQuestions(list);
    }




}
