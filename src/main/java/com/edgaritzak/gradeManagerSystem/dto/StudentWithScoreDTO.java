package com.edgaritzak.gradeManagerSystem.dto;

public class StudentWithScoreDTO {

	private int idInscription;
	private int idStudent;
	private String firstName;
	private String lastName;
	private int score;
	
	public StudentWithScoreDTO(int idInscription, int idStudent, String firstName, String lastName, int score) {
		this.idInscription = idInscription;
		this.idStudent = idStudent;
		this.firstName = firstName;
		this.lastName = lastName;
		this.score = score;
	}
	
	
	public int getIdInscription() {
		return idInscription;
	}


	public void setIdInscription(int idInscription) {
		this.idInscription = idInscription;
	}


	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "StudentWithScoreDTO [IdStudent=" + idStudent + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", score=" + score + "]";
	}
}
