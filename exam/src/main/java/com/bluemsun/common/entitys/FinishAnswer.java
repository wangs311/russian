package com.bluemsun.common.entitys;

/**
* @ClassName: FinishAnswer
* @Description: 学生答案的实体类
* @author Kyrie Irving
* @date 2017年8月7日 下午2:42:04
*/
public class FinishAnswer {
	
	private String id;
	
	private String finishExaminationId;
	
	private String questionId;
	
	private String finishAnswerContent;
	
	private int finishAnswerMark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFinishExaminationId() {
		return finishExaminationId;
	}

	public void setFinishExaminationId(String finishExaminationId) {
		this.finishExaminationId = finishExaminationId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getFinishAnswerContent() {
		return finishAnswerContent;
	}

	public void setFinishAnswerContent(String finishAnswerContent) {
		this.finishAnswerContent = finishAnswerContent;
	}

	public int getFinishAnswerMark() {
		return finishAnswerMark;
	}

	public void setFinishAnswerMark(int finishAnswerMark) {
		this.finishAnswerMark = finishAnswerMark;
	}





}
