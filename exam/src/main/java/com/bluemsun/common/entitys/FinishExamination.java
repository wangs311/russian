package com.bluemsun.common.entitys;

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

}
