package com.edgaritzak.gradeManagerSystem.service;

import java.util.List;
import java.util.Optional;

import com.edgaritzak.gradeManagerSystem.entity.Student;
import com.edgaritzak.gradeManagerSystem.entity.SystemUser;

public interface SystemUserService {

	public List<SystemUser> findStudentsByGroup(int groupId);
	public SystemUser findTeacherById(int teacherId);
	public SystemUser findStudentById(int studentId);
	public SystemUser findUserById(int userId);
	
}
