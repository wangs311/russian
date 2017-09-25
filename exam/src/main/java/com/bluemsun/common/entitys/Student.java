package com.bluemsun.common.entitys;

/**
 * @ClassName: Student
 * @Description: 学生实体类
 * @author Kyrie Irving
 * @date 2017年8月7日 下午2:34:37
 */
public class Student {

	private String id;

	private String studentName;

	private String studentNumber;

	private String studentPassword;

	private String studentGrade;

	private String studentIsDelete;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public String getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}

	public String getStudentIsDelete() {
		return studentIsDelete;
	}

	public void setStudentIsDelete(String studentIsDelete) {
		this.studentIsDelete = studentIsDelete;
	}

}
