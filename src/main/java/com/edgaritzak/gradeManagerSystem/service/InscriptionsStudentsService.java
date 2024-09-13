package com.edgaritzak.gradeManagerSystem.service;

import java.util.List;

import com.edgaritzak.gradeManagerSystem.entity.InscriptionsStudents;

public interface InscriptionsStudentsService {
	
	//UPDATE A SCORE OF A INSCRIPTION
	void updateScore(int idInscription, double score);
	//GET A INSCRIPTION RECORD BY ID
	InscriptionsStudents findInscriptionsStudentsById(int id);
	//GET THE LIST OF INSCRIPTIONS LINKED TO A GROUP (ID)
	List<InscriptionsStudents> findInscriptionsStudentsByGroupId(int groupId);
	//GET THE LIST OF INSCRIPTIONS LINKED TO A Student (ID)
	List<InscriptionsStudents> findInscriptionsStudentsByStudentId(int studentId);
}
