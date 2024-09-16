package com.edgaritzak.gradeManagerSystem.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgaritzak.gradeManagerSystem.dto.CourseGroupWithScoreDTO;
import com.edgaritzak.gradeManagerSystem.dto.GroupWithCourseDTO;
import com.edgaritzak.gradeManagerSystem.entity.Group;
import com.edgaritzak.gradeManagerSystem.entity.Course;
import com.edgaritzak.gradeManagerSystem.entity.InscriptionsStudents;
import com.edgaritzak.gradeManagerSystem.repository.CourseRepository;
import com.edgaritzak.gradeManagerSystem.repository.GroupRepository;
import com.edgaritzak.gradeManagerSystem.repository.InscriptionsStudentsRepository;

import jakarta.transaction.Transactional;

@Service
public class GroupServiceImpl implements GroupService {
	
	CourseRepository courseRepo;
	GroupRepository groupRepo;
	InscriptionsStudentsRepository inscriptionsStudentsRepo;
	@Autowired
	public GroupServiceImpl(GroupRepository groupRepo, InscriptionsStudentsRepository inscriptionsStudentsRepo,
			CourseRepository courseRepo) {
		this.groupRepo = groupRepo;
		this.inscriptionsStudentsRepo = inscriptionsStudentsRepo;
		this.courseRepo = courseRepo;
	}
	
	@Transactional
	public void deleteAllInscriptiosByStudentId(int id) {
		inscriptionsStudentsRepo.deleteByStudentId(id);
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
						e.getCourse().getDescription(),
						e.getSemester(), 
						e.getYear()))
				.collect(Collectors.toList());
	}
	
	//GETS A LIST WITH ALL GroupWithCourseDTO(COURSES) A STUDENT(ID) HAS IN A SPECIFIC PERIOD
	@Override
	public List<GroupWithCourseDTO> findStudentsGroupWithCourseDTOByTerm(int studentId, int semester, int year) {
		List<Group> groupList = groupRepo.findStudentsGroupsByTerm(studentId, semester, year);
		return groupList.stream()
				.map(e -> new GroupWithCourseDTO(
						e.getId(), 
						e.getCourse().getName(), 
						e.getCourse().getDescription(),
						e.getSemester(), 
						e.getYear()))
				.collect(Collectors.toList());
	}
	//GETS A LIST WITH ALL GroupWithCourseDTO(COURSES) A TEACHER(ID) HAS
	@Override
	public List<GroupWithCourseDTO> findTeachersGroupWithCourseDTO(int teacherId) {
		List<Group> groupList = groupRepo.findTeachersGroups(teacherId);
		return groupList.stream()
				.map(e -> new GroupWithCourseDTO(
						e.getId(), 
						e.getCourse().getName(),
						e.getCourse().getDescription(),
						e.getSemester(), 
						e.getYear()))
				.collect(Collectors.toList());
	}
	
	//GETS A LIST WITH ALL GroupWithCourseDTO
	public List<GroupWithCourseDTO> findAllGroupWithCourseDTO() {
		List<Group> groupList = groupRepo.findAll();
		return groupList.stream()
				.map(e -> new GroupWithCourseDTO(
						e.getId(), 
						e.getCourse().getName(), 
						e.getCourse().getDescription(),
						e.getSemester(), 
						e.getYear(),
						e.getTeacher().getSystemUser().getFirstName()+" "+e.getTeacher().getSystemUser().getLastName()))
				.collect(Collectors.toList());
	}
	
	//GETS A LIST WITH ALL Group A STUDENT(ID) HAS
	@Override
	public List<GroupWithCourseDTO> findStudentsGroupWithCourseDTO(int studentId) {
		List<Group> groupList = groupRepo.findStudentsGroups(studentId);
		return groupList.stream()
				.map(e -> new GroupWithCourseDTO(
						e.getId(), 
						e.getCourse().getName(), 
						e.getCourse().getDescription(),
						e.getSemester(), 
						e.getYear()))
				.collect(Collectors.toList());
	}
	
	//GETS A LIST WITH ALL CourseGroupWithScoreDTO(INSCRIPTIONS) A STUDENT(ID) HAS 
	@Override
	public List<CourseGroupWithScoreDTO> findStudentsCourseGroupWithScoreDTO(int studentId){
		List<InscriptionsStudents> groupList = inscriptionsStudentsRepo.findInscriptionsStudentsByStudentId(studentId);
		return groupList.stream()
				.map(e -> new CourseGroupWithScoreDTO(
						e.getId(),
						e.getGroup().getId(),
						e.getGroup().getCourse().getName(),
						e.getGroup().getCourse().getDescription(),
						(e.getGroup().getTeacher().getSystemUser().getFirstName()+" "+e.getGroup().getTeacher().getSystemUser().getLastName()),
						e.getGroup().getSemester(), 
						e.getGroup().getYear(),
						e.getScore()))
				.collect(Collectors.toList());
	}
	
	//GETS A CourseGroupWithScoreDTO(INSCRIPTIONS) BY GROUP ID
		@Override
		public GroupWithCourseDTO findGroupWithCourseDTOByGroupId(int groupId){
			Group group = groupRepo.findById(groupId).get();
		
			return (new GroupWithCourseDTO(
						group.getId(),
						group.getCourse().getName(),
						group.getCourse().getDescription(),
						group.getSemester(),
						group.getYear()));
					}

		public List<Course> findAllCourses() {
			return courseRepo.findAll();
		}
		public List<Group> findAllGroups() {
			return groupRepo.findAll();
		}
}
