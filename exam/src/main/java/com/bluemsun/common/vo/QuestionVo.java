package com.bluemsun.common.vo;

import com.bluemsun.common.entitys.FinishAnswer;
import com.bluemsun.common.entitys.Question;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/8/28 18:46
 */

public class QuestionVo extends Question {

    private String[] outline;

    private FinishAnswer finishAnswer;

    private String studentAnswer;

    private int studentMark;

    public int getStudentMark() {
        return studentMark;
    }

    public void setStudentMark(int studentMark) {
        this.studentMark = studentMark;
    }

    public FinishAnswer getFinishAnswer() {
        return finishAnswer;
    }

    public void setFinishAnswer(FinishAnswer finishAnswer) {
        this.finishAnswer = finishAnswer;
    }

    public String[] getOutline() {
        return outline;
    }

    public void setOutline(String[] outline) {
        this.outline = outline;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }

}
