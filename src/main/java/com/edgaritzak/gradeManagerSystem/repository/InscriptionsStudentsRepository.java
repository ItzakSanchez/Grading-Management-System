package com.edgaritzak.gradeManagerSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edgaritzak.gradeManagerSystem.entity.InscriptionsStudents;

public interface InscriptionsStudentsRepository extends JpaRepository<InscriptionsStudents, Integer>{
	
	//GET INSCRIPTIONS WHERE GROUPID
	@Query("Select I from InscriptionsStudents AS I JOIN I.group AS G WHERE G.id = :groupId")
	List<InscriptionsStudents> findInscriptionsStudentsByGroupId(@Param("groupId")int groupId);
	
	//UPDATE INSCRIPTION SCORE
	@Query("Update InscriptionsStudents I SET I.score = :score where id = :idInscription")
	InscriptionsStudents updateScore(@Param("idInscription")int idInscription,@Param("score") double score);
}
