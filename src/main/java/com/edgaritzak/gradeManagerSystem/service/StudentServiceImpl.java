package com.edgaritzak.gradeManagerSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edgaritzak.gradeManagerSystem.entity.Student;
import com.edgaritzak.gradeManagerSystem.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	StudentRepository studentRepo;
	
	@Autowired
	public StudentServiceImpl(StudentRepository groupRepo) {
		this.studentRepo = groupRepo;
	}

	@Override
	public Student findBySystemUserId(int systemUserId) {
		return studentRepo.findBySystemUserId(systemUserId);
	}
}
