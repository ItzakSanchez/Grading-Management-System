package com.edgaritzak.gradeManagerSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgaritzak.gradeManagerSystem.entity.Teacher;
import com.edgaritzak.gradeManagerSystem.repository.TeacherRepository;
@Service
public class TeacherServiceImpl implements TeacherService {

	TeacherRepository teacherRepo;
	@Autowired
	public TeacherServiceImpl(TeacherRepository teacherRepo) {
		this.teacherRepo = teacherRepo;
	}
	
	@Override
	public Teacher findBySystemUserId(int systemUserId) {
		return teacherRepo.findBySystemUserId(systemUserId);
	}

}
