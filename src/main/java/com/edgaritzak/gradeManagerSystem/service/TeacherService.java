package com.edgaritzak.gradeManagerSystem.service;

import com.edgaritzak.gradeManagerSystem.entity.Teacher;

public interface TeacherService {
	
	Teacher findBySystemUserId(int systemUserId);
}
