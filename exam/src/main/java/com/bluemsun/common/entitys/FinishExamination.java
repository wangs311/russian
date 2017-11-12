package com.bluemsun.common.entitys;

import java.util.Date;

/**
 * @ClassName: FinishExamination
 * @Description: 学生已完成的试卷的实体类
 * @author Kyrie Irving
 * @date 2017年8月7日 下午2:42:58
 */
public class FinishExamination {

	private String id;

	private String studentId;

	private String examinationId;

	private String finishAlready;

	private String unitId;

	private int finishMark;

	private Date finishTime;

	public int getFinishMark() {
		return finishMark;
	}

	public void setFinishMark(int finishMark) {
		this.finishMark = finishMark;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(String examinationId) {
		this.examinationId = examinationId;
	}

	public String getFinishAlready() {
		return finishAlready;
	}

	public void setFinishAlready(String finishAlready) {
		this.finishAlready = finishAlready;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public FinishExamination(String studentId, String examinationId, String unitId) {
		this.studentId = studentId;
		this.examinationId = examinationId;
		this.unitId = unitId;
	}

	public FinishExamination() {

	}
}
