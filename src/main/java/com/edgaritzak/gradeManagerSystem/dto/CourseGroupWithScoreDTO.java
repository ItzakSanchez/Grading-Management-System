package com.edgaritzak.gradeManagerSystem.dto;

public class CourseGroupWithScoreDTO {

	private int idInscription;
	private int idGroup;
	private String courseName;
	private String courseDescription;
	private String teacherName;
	private int semester;
	private int year;
	private double score;
	
	public CourseGroupWithScoreDTO(int idInscription, int idGroup, String courseName, String courseDescription,
			String teacherName, int semester, int year, double score) {
		super();
		this.idInscription = idInscription;
		this.idGroup = idGroup;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.teacherName = teacherName;
		this.semester = semester;
		this.year = year;
		this.score = score;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getIdInscription() {
		return idInscription;
	}

	public void setIdInscription(int idInscription) {
		this.idInscription = idInscription;
	}

	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
}
