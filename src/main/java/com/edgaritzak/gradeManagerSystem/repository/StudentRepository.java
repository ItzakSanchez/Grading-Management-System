package com.edgaritzak.gradeManagerSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edgaritzak.gradeManagerSystem.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
	
	Student findBySystemUserId(int systemUserId);
}
