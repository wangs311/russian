package com.bluemsun.common.vo;

import com.bluemsun.common.entitys.FinishExamination;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/9/13 9:17
 */
public class FinishExaminationVo extends FinishExamination {

    private String examinationName;

    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getExaminationName() {
        return examinationName;
    }

    public void setExaminationName(String examinationName) {
        this.examinationName = examinationName;
    }
}
