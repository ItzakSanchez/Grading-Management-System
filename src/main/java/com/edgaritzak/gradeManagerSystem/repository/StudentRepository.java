package com.edgaritzak.gradeManagerSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.edgaritzak.gradeManagerSystem.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
	
	@Query("Select S FROM Student AS S"
	+ " JOIN S.systemUser as SU"
	+ " WHERE SU.id = :systemUserId")
	Student findBySystemUserId(@Param("systemUserId")int systemUserId);
}
