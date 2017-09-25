package com.bluemsun.service.Examination;

import com.bluemsun.common.entitys.FinishExamination;
import com.bluemsun.common.vo.FinishExaminationVo;
import com.bluemsun.dao.Examination.FinishExaminationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/9/13 19:35
 */
@Service
public class FinishExaminationService {

    @Autowired
    private FinishExaminationDao finishExaminationDao;


    /**
    * @Description: 添加一套已完成的试卷
    * @Date: 2017/9/13 19:35
    */
    public void addFinishExamination(FinishExamination finishExamination) {
        finishExaminationDao.addFinishExamination(finishExamination);
    }


    /**
    * @Description: 更改一套试卷的处理状态
    * @Date: 2017/9/13 19:46
    */
    public void updateFinishExamination(String id) {
        finishExaminationDao.updateFinExam(id);
    }


    /**
    * @Description: 根据id查询一套完成的试卷
    * @Date: 2017/9/13 19:43
    */
    public FinishExaminationVo selectFinExamById(String id) {
        return finishExaminationDao.selectFinExamById(id);
    }


    /**
    * @Description: 多条件查询完成的试卷
    * @Date: 2017/9/13 19:44
    */
    public List<FinishExaminationVo> selectFinExamByUnit(String unit, int grade, String studentId) {
        return finishExaminationDao.selectFinExamByUnit(unit, grade, studentId);
    }


}
