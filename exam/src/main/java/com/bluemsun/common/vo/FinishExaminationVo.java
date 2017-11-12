package com.bluemsun.common.vo;

import com.bluemsun.common.entitys.FinishExamination;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/9/13 9:17
 */
public class FinishExaminationVo extends FinishExamination {

    private String editionName;

    private String unitName;

    private String examinationName;

    private String studentName;

    private String dateFormat;

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

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

    public String getEditionName() {
        return editionName;
    }

    public void setEditionName(String editionName) {
        this.editionName = editionName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
