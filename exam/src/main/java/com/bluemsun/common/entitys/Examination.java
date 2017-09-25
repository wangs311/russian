package com.bluemsun.common.entitys;

/**
* @ClassName: Examination
* @Description: 试卷的实体类
* @author Kyrie Irving
* @date 2017年8月7日 下午2:47:47
*/
public class Examination {
    private String id;

    private String unitId;

    private String questionsId;

    private String examinationName;

	private int examinationMark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getQuestionsId() {
		return questionsId;
	}

	public void setQuestionsId(String questionsId) {
		this.questionsId = questionsId;
	}

	public int getExaminationMark() {
		return examinationMark;
	}

	public void setExaminationMark(int examinationMark) {
		this.examinationMark = examinationMark;
	}

	public String getExaminationName() {
		return examinationName;
	}

	public void setExaminationName(String examinationName) {
		this.examinationName = examinationName;
	}





}