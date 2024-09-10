package com.edgaritzak.gradeManagerSystem.service;

import java.util.List;
import java.util.Optional;

import com.edgaritzak.gradeManagerSystem.entity.Student;

public interface StudentService {
	
	Student findBySystemUserId(int systemUserId);
}
