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
    public String addFinishExamination(FinishExamination finishExamination) {
        String id = finishExaminationDao.addFinishExamination(finishExamination);
        return id;
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
    * @Description: 学生查看试卷
    * @Date: 2017/9/13 19:44
    */
    public List<FinishExaminationVo> selectFromStudent(String studentId) {
        return finishExaminationDao.selectFromStudent(studentId);
    }

    /**
    * @Description: 老师查询
    * @Date: 2017/10/11 19:30
    */
    public List<FinishExaminationVo> selectFromTeacher(String editionId, String finishAlready, String unitId) {
        return finishExaminationDao.selectFromTeacher(editionId, finishAlready, unitId);
    }


    /**
    * @Description: 更改试卷的分数
    * @Date: 2017/10/11 21:37
    */
    public void updateMark(int mark, String id) {
        finishExaminationDao.updateMark(mark, id);
    }


}
