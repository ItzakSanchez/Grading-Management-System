package com.edgaritzak.gradeManagerSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edgaritzak.gradeManagerSystem.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Integer>{

}
