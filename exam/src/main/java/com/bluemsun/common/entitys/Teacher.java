package com.bluemsun.common.entitys;

/**
 * @ClassName: Teacher
 * @Description: 教师的实体类
 * @author Kyrie Irving
 * @date 2017年8月7日 下午2:37:23
 */
public class Teacher {

	private String id;

	private String teacherName;

	private String teacherNumber;

	private String teacherPassword;

	private String teacherEdition;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherNumber() {
		return teacherNumber;
	}

	public void setTeacherNumber(String teacherNumber) {
		this.teacherNumber = teacherNumber;
	}

	public String getTeacherPassword() {
		return teacherPassword;
	}

	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}

	public String getTeacherEdition() {
		return teacherEdition;
	}

	public void setTeacherEdition(String teacherEdition) {
		this.teacherEdition = teacherEdition;
	}

}
