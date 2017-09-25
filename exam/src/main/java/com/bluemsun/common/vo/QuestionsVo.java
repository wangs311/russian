package com.bluemsun.common.vo;

import com.bluemsun.common.entitys.Questions;

import java.util.List;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/8/28 18:47
 */
public class QuestionsVo extends Questions {

    private List<QuestionVo> questionList;

    public List<QuestionVo> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionVo> questionList) {
        this.questionList = questionList;
    }
}
