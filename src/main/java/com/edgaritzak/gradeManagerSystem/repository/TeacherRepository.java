package com.edgaritzak.gradeManagerSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edgaritzak.gradeManagerSystem.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

	Teacher findBySystemUserId(int systemUserId);
}
