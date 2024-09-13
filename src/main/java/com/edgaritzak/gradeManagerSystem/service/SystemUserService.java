package com.edgaritzak.gradeManagerSystem.service;

import java.util.List;

import com.edgaritzak.gradeManagerSystem.dto.StudentWithScoreDTO;
import com.edgaritzak.gradeManagerSystem.entity.SystemUser;

public interface SystemUserService {

	List<SystemUser> findStudentsByGroup(int groupId);
	SystemUser findTeacherById(int teacherId);
	SystemUser findStudentById(int studentId);
	SystemUser findUserById(int userId);
	
	List<StudentWithScoreDTO> findStudentsWithScoreByGroup(int groupId);
	
	List<SystemUser> findAll();
	
	SystemUser findByEmail(String email);
}
