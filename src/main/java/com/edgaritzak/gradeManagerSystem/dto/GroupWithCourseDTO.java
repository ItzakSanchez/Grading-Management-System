package com.edgaritzak.gradeManagerSystem.dto;

public class GroupWithCourseDTO {
	
	private int groupId;
	private String courseName;
	private String description;
	private int semester;
	private int year;
	private String teacher;
	
	public GroupWithCourseDTO(int groupId, String courseName, String description, int semester, int year) {
		super();
		this.groupId = groupId;
		this.courseName = courseName;
		this.description = description;
		this.semester = semester;
		this.year = year;
	}
	
	public GroupWithCourseDTO(int groupId, String courseName, String description, int semester, int year, String teacher) {
		super();
		this.groupId = groupId;
		this.courseName = courseName;
		this.description = description;
		this.semester = semester;
		this.year = year;
		this.teacher = teacher;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "GroupWithCourseDTO [groupId=" + groupId + ", courseName=" + courseName + ", semester=" + semester
				+ ", year=" + year + "]";
	}
	
}
