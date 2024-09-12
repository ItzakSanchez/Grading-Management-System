package com.edgaritzak.gradeManagerSystem.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgaritzak.gradeManagerSystem.dto.GroupWithCourseDTO;
import com.edgaritzak.gradeManagerSystem.entity.Group;
import com.edgaritzak.gradeManagerSystem.repository.GroupRepository;

@Service
public class GroupServiceImpl implements GroupService {

	GroupRepository groupRepo;
	@Autowired
	public GroupServiceImpl(GroupRepository groupRepo) {
		this.groupRepo = groupRepo;
	}

	@Override
	public Group findGroupById(int id) {
		Group group = groupRepo.findById(id).orElseThrow(()-> new NoSuchElementException("No value present"));
		return group;
	}

	@Override
	public List<Group> findTeachersGroups(int teacherId) {
		return groupRepo.findTeachersGroups(teacherId);
	}

	@Override
	public List<Group> findTeachersGroupsByTerm(int teacherId, int semester, int year) {
		return groupRepo.findTeachersGroupsByTerm(teacherId, semester, year);
	}

	@Override
	public List<Group> findStudentsGroups(int studentId) {
		return groupRepo.findStudentsGroups(studentId);
	}

	@Override
	public List<Group> findStudentsGroupsByTerm(int studentId, int semester, int year) {
		return groupRepo.findStudentsGroupsByTerm(studentId, semester, year);
	}

	//GETS A LIST WITH ALL COURSES A TEACHER(ID) HAS IN A SPECIFIC PERIOD
	@Override
	public List<GroupWithCourseDTO> findTeachersGroupWithCourseDTOByTerm(int teacherId, int semester, int year) {
		List<Group> groupList = groupRepo.findTeachersGroupsByTerm(teacherId, semester, year);
		return groupList.stream()
				.map(e -> new GroupWithCourseDTO(
						e.getId(), 
						e.getCourse().getName(), 
						e.getSemester(), 
						e.getYear()))
				.collect(Collectors.toList());
	}
	
	//GETS A LIST WITH ALL COURSES A STUDENT(ID) HAS IN A SPECIFIC PERIOD
	@Override
	public List<GroupWithCourseDTO> findStudentsGroupWithCourseDTOByTerm(int studentId, int semester, int year) {
		List<Group> groupList = groupRepo.findStudentsGroupsByTerm(studentId, semester, year);
		return groupList.stream()
				.map(e -> new GroupWithCourseDTO(
						e.getId(), 
						e.getCourse().getName(), 
						e.getSemester(), 
						e.getYear()))
				.collect(Collectors.toList());
	}

	@Override
	public List<GroupWithCourseDTO> findTeachersGroupWithCourseDTO(int teacherId) {
		List<Group> groupList = groupRepo.findTeachersGroups(teacherId);
		return groupList.stream()
				.map(e -> new GroupWithCourseDTO(
						e.getId(), 
						e.getCourse().getName(), 
						e.getSemester(), 
						e.getYear()))
				.collect(Collectors.toList());
	}

	@Override
	public List<GroupWithCourseDTO> findStudentsGroupWithCourseDTO(int studentId) {
		List<Group> groupList = groupRepo.findStudentsGroups(studentId);
		return groupList.stream()
				.map(e -> new GroupWithCourseDTO(
						e.getId(), 
						e.getCourse().getName(), 
						e.getSemester(), 
						e.getYear()))
				.collect(Collectors.toList());
	}
	
	
}
