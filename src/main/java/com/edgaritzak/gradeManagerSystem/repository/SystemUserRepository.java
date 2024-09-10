package com.edgaritzak.gradeManagerSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edgaritzak.gradeManagerSystem.entity.SystemUser;

public interface SystemUserRepository extends JpaRepository<SystemUser, Integer>{

	//GET STUDENTS DATA FROM A PARTICULAR GROUP (ID)
	@Query("SELECT SU FROM SystemUser as SU"
	+" JOIN SU.student as S"
	+" JOIN S.inscriptionsStudents as I"
	+" JOIN I.group AS G"
	+" WHERE G.id = :groupId")
	List<SystemUser> findStudentsByGroup(@Param("groupId")int groupId);
		
	//FIND TEACHER BY ID
	@Query("SELECT SU FROM SystemUser as SU"
	+" JOIN SU.teacher as T"
	+" WHERE T.id = :teacharId")
	Optional<SystemUser> findTeacherById(@Param("teacharId")int idTeacher);
	
	//FIND Student BY ID
	@Query("SELECT SU FROM SystemUser as SU"
	+" JOIN SU.student as S"
	+" WHERE S.id = :studentId")
	Optional<SystemUser> findStudentById(@Param("studentId")int idStudent);
		
	//FIND SystemUser BY ID
	@Query("SELECT SU FROM SystemUser as SU"
	+" WHERE SU.id = :systemUserId")
	Optional<SystemUser> findUserById(@Param("systemUserId")int systemUserId);
}
