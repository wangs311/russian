package com.bluemsun.common.entitys;

/**
 * @ClassName: Question
 * @Description: 小题的实体类
 * @author Kyrie Irving
 * @date 2017年8月7日 下午2:44:10
 */
public class Question {

	private String id;

	private String questionsId;

	private String questionOutline;

	private String questionAnswer;

	private String questionAnalysis;

	private int questionMark;

	private int questionNumber;

	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestionsId() {
		return questionsId;
	}

	public void setQuestionsId(String questionsId) {
		this.questionsId = questionsId;
	}

	public String getQuestionOutline() {
		return questionOutline;
	}

	public void setQuestionOutline(String questionOutline) {
		this.questionOutline = questionOutline;
	}

	public String getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public String getQuestionAnalysis() {
		return questionAnalysis;
	}

	public void setQuestionAnalysis(String questionAnalysis) {
		this.questionAnalysis = questionAnalysis;
	}

	public int getQuestionMark() {
		return questionMark;
	}

	public void setQuestionMark(int questionMark) {
		this.questionMark = questionMark;
	}

}