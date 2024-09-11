package com.edgaritzak.gradeManagerSystem.dto;

public class StudentWithScoreDTO {

	private int IdStudent;
	private String firstName;
	private String lastName;
	private double score;
	
	public StudentWithScoreDTO(int idStudent, String firstName, String lastName, double score) {
		IdStudent = idStudent;
		this.firstName = firstName;
		this.lastName = lastName;
		this.score = score;
	}
	
	
	public int getIdStudent() {
		return IdStudent;
	}

	public void setIdStudent(int idStudent) {
		IdStudent = idStudent;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "StudentWithScoreDTO [IdStudent=" + IdStudent + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", score=" + score + "]";
	}
}
