package com.edgaritzak.gradeManagerSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edgaritzak.gradeManagerSystem.entity.InscriptionsStudents;

public interface InscriptionsStudentsRepository extends JpaRepository<InscriptionsStudents, Integer>{
	
	//GET INSCRIPTIONS WHERE GROUPID
	@Query("Select I from InscriptionsStudents AS I JOIN I.group AS G WHERE G.id = :groupId")
	List<InscriptionsStudents> findInscriptionsStudentsByGroupId(@Param("groupId")int groupId);
	
	//UPDATE INSCRIPTION SCORE
	@Modifying
	@Query("Update InscriptionsStudents I SET I.score = :score where I.id = :idInscription")
	void updateScore(@Param("idInscription")int idInscription,@Param("score") double score);
	
	
	@Query("Select I from InscriptionsStudents AS I WHERE I.student.id = :studentId")
	List<InscriptionsStudents> findInscriptionsStudentsByStudentId(@Param("studentId")int studentId);

	@Modifying
	@Query("Delete from InscriptionsStudents AS I WHERE I.student.id = :studentId")
	void deleteByStudentId(@Param("studentId")int id);
}
