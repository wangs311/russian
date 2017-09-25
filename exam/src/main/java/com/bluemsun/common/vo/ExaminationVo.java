package com.bluemsun.common.vo;

import com.bluemsun.common.entitys.Examination;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/9/12 18:38
 */
public class ExaminationVo extends Examination {

    private String[] questionsList;

    public String[] getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(String[] questionsList) {
        this.questionsList = questionsList;
    }
}
