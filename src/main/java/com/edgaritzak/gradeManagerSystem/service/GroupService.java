package com.edgaritzak.gradeManagerSystem.service;

import java.util.List;

import com.edgaritzak.gradeManagerSystem.dto.CourseGroupWithScoreDTO;
import com.edgaritzak.gradeManagerSystem.dto.GroupWithCourseDTO;
import com.edgaritzak.gradeManagerSystem.entity.Group;

public interface GroupService {
	
	Group findGroupById(int id);
	List<Group>findTeachersGroups(int teacherId);
	List<Group>findTeachersGroupsByTerm(int teacherId, int semester, int year);
	List<Group>findStudentsGroups(int studentId);
	List<Group>findStudentsGroupsByTerm(int studentId,  int semester, int year);
	
	List<GroupWithCourseDTO>findTeachersGroupWithCourseDTO(int teacherId);
	List<GroupWithCourseDTO>findStudentsGroupWithCourseDTO(int studentId);
	
	List<GroupWithCourseDTO>findTeachersGroupWithCourseDTOByTerm(int teacherId, int semester, int year);
	List<GroupWithCourseDTO>findStudentsGroupWithCourseDTOByTerm(int studentId, int semester, int year);
	
	List<CourseGroupWithScoreDTO> findStudentsCourseGroupWithScoreDTO(int studentId);
	
	GroupWithCourseDTO findGroupWithCourseDTOByGroupId(int groupId);
}
