package com.edgaritzak.gradeManagerSystem.service;

import com.edgaritzak.gradeManagerSystem.entity.Student;

public interface StudentService {
	
	Student findBySystemUserId(int systemUserId);
}
