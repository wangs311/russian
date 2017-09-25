package com.bluemsun.service.Examination;

import com.bluemsun.common.entitys.Examination;
import com.bluemsun.common.vo.ExaminationVo;
import com.bluemsun.dao.Examination.ExaminationDao;
import com.bluemsun.dao.Examination.FinishAnswerDao;
import com.bluemsun.dao.Examination.FinishExaminationDao;
import com.bluemsun.dao.Examination.QuestionsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/9/12 18:49
 */
@Service
public class ExaminationService {

    @Autowired
    private ExaminationDao examinationDao;

    @Autowired
    private QuestionsDao questionsDao;

    @Autowired
    private FinishExaminationDao finishExaminationDao;

    @Autowired
    private FinishAnswerDao finishAnswerDao;


    /**
    * @Description: 插入一个试卷
    * @Date: 2017/9/12 18:49
    */
    public void addExamination(Examination examination) {
        String[] questionsList = examination.getQuestionsId().split("#");
        int mark = 0;
        for(int i = 0; i < questionsList.length; i++) {
            mark += questionsDao.selectQuestionsVoById(questionsList[i]).getQuestionsMark();
        }
        examination.setExaminationMark(mark);
        examinationDao.addExamination(examination);
    }


    /**
    * @Description: 删除一个试卷同时删除所有已完成这套试卷的记录
    * @Date: 2017/9/12 19:14
    */
    public void deleteExamination(String id) {
        examinationDao.deleteExamination(id);
        finishExaminationDao.deleteFinishExamination(id);
        finishExaminationDao.deleteFinishExamination(id);

    }


    /**
    * @Description: 根据id查看一套试卷
    * @Date: 2017/9/12 19:16
    */
    public ExaminationVo selectExamination(String id) {
        ExaminationVo examinationVo = examinationDao.selectExamination(id);
        String[] questionsList = examinationVo.getQuestionsId().split("#");
        examinationVo.setQuestionsList(questionsList);
        return examinationVo;
    }


    /**
    * @Description: 根据单元id查看一套试卷
    * @Date: 2017/9/12 19:23
    */
    public List<ExaminationVo> selectAllExamination(String unitId) {
        List<ExaminationVo> list = examinationDao.selectAllExamination(unitId);
        String[] questionsList = null;
        for(int i = 0; i < list.size(); i++) {
            questionsList = list.get(i).getQuestionsId().split("#");
            list.get(i).setQuestionsList(questionsList);
        }
        return list;
    }

}
