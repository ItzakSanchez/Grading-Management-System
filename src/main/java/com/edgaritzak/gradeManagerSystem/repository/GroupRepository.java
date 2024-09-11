package com.edgaritzak.gradeManagerSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edgaritzak.gradeManagerSystem.entity.Group;

public interface GroupRepository extends JpaRepository<Group,Integer>{
	
	//SELECT ALL TEACHERS GROUPS
	@Query("Select G from Group AS G WHERE G.teacher.id = :teacherId")
	List<Group> findTeachersGroups(@Param("teacherId")int teacherId);
	
	//SELECT ALL TEACHERS GROUPS BY TERM
	@Query("Select G from Group AS G WHERE G.teacher.id = :teacherId"
	+" AND G.semester = :semester AND G.year = :year")
	List<Group> findTeachersGroupsByTerm(@Param("teacherId")int idTeacher, 
	@Param("semester")int semester,@Param("year")int year);
	
	
	//SELECT ALL GROUPS OF A STUDENT
	@Query("Select G FROM from Group AS G"
	+" JOIN G.inscriptionsStudents AS I"
	+" JOIN I.student AS S"
	+" WHERE S.id = :studentId")
	List<Group> findStudentsGroups(@Param("studentId")int studentId);
	
	//SELECT ALL GROUPS OF A STUDENT BY TERM
	@Query("Select G FROM from Group AS G"
	+" JOIN G.inscriptionsStudents AS I"
	+" JOIN I.student AS S"
	+" WHERE S.id = :studentId"
	+" AND G.semester = :semester AND G.year = :year")
	List<Group> findStudentsGroupsByTerm(@Param("studentId")int studentId,
	@Param("semester")int semester,@Param("year")int year);
	
	
	
}
