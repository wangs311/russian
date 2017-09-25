package com.bluemsun.common.entitys;

/**
 * @ClassName: Questions
 * @Description: 大题实体类
 * @author Kyrie Irving
 * @date 2017年8月7日 下午2:27:15
 */
public class Questions {
	
	private String id;

	private String questionsTitle;

	private String questionsArticle;

	private String questionsTypeId;

	private int questionsMark;

	private String unitId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestionsTitle() {
		return questionsTitle;
	}

	public void setQuestionsTitle(String questionsTitle) {
		this.questionsTitle = questionsTitle;
	}

	public String getQuestionsArticle() {
		return questionsArticle;
	}

	public void setQuestionsArticle(String questionsArticle) {
		this.questionsArticle = questionsArticle;
	}

	public String getQuestionsTypeId() {
		return questionsTypeId;
	}

	public void setQuestionsTypeId(String questionsTypeId) {
		this.questionsTypeId = questionsTypeId;
	}

	public int getQuestionsMark() {
		return questionsMark;
	}

	public void setQuestionsMark(int questionsMark) {
		this.questionsMark = questionsMark;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	
	
}