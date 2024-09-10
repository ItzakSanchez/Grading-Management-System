package com.edgaritzak.gradeManagerSystem.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgaritzak.gradeManagerSystem.entity.SystemUser;
import com.edgaritzak.gradeManagerSystem.repository.SystemUserRepository;

@Service
public class SystemUserServiceImpl implements SystemUserService{
	
	SystemUserRepository systemUserRepo;
	@Autowired
	public SystemUserServiceImpl(SystemUserRepository systemUserRepo) {
		this.systemUserRepo = systemUserRepo;
	}
	
	@Override
	public List<SystemUser> findStudentsByGroup(int groupId) {
		return systemUserRepo.findStudentsByGroup(groupId);
	}

	@Override
	public SystemUser findTeacherById(int teacherId) {
		SystemUser teacher = systemUserRepo.findTeacherById(teacherId)
				.orElseThrow(()->new NoSuchElementException("No value present"));
		return teacher;
	}

	@Override
	public SystemUser findStudentById(int studentId) {
		SystemUser student = systemUserRepo.findStudentById(studentId)
				.orElseThrow(()->new NoSuchElementException("No value present"));
		return student;
	}

	@Override
	public SystemUser findUserById(int userId) {
		SystemUser user = systemUserRepo.findUserById(userId)
				.orElseThrow(()->new NoSuchElementException("No value present"));
		return user;
	}


}
