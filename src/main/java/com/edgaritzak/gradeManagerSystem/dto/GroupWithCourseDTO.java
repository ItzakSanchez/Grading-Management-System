package com.edgaritzak.gradeManagerSystem.dto;

public class GroupWithCourseDTO {
	
	private int groupId;
	private String courseName;
	private int semester;
	private int year;
	
	public GroupWithCourseDTO(int groupId, String courseName, int semester, int year) {
		super();
		this.groupId = groupId;
		this.courseName = courseName;
		this.semester = semester;
		this.year = year;
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

	@Override
	public String toString() {
		return "GroupWithCourseDTO [groupId=" + groupId + ", courseName=" + courseName + ", semester=" + semester
				+ ", year=" + year + "]";
	}
	
}
