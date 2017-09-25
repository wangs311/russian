package com.bluemsun.controller.front;

import com.bluemsun.common.entitys.Edition;
import com.bluemsun.common.entitys.Unit;
import com.bluemsun.common.vo.ExaminationVo;
import com.bluemsun.common.vo.QuestionsVo;
import com.bluemsun.service.Examination.EditionService;
import com.bluemsun.service.Examination.ExaminationService;
import com.bluemsun.service.Examination.QuestionsService;
import com.bluemsun.service.Examination.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
    @RequestMapping("/toExamination")
    @ResponseBody
    public List toExamination(String examinationId) {
        ExaminationVo examinationVo = examinationService.selectExamination(examinationId);
        List<QuestionsVo> list = new ArrayList<QuestionsVo>();
        for(int i = 0; i < examinationVo.getQuestionsList().length; i++) {
            list.add(questionsService.selectQuestionsById(examinationVo.getQuestionsList()[i], null));
        }
        List result = new ArrayList();
        result.add(list);
        result.add(examinationVo);
        return list;
        //return Pages.FRONTEXAM;
    }




}
