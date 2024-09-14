package com.edgaritzak.gradeManagerSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgaritzak.gradeManagerSystem.dto.StudentWithScoreDTO;
import com.edgaritzak.gradeManagerSystem.dto.SystemUserWithRoleIdDTO;
import com.edgaritzak.gradeManagerSystem.entity.InscriptionsStudents;
import com.edgaritzak.gradeManagerSystem.entity.Student;
import com.edgaritzak.gradeManagerSystem.entity.SystemUser;
import com.edgaritzak.gradeManagerSystem.entity.Teacher;
import com.edgaritzak.gradeManagerSystem.repository.InscriptionsStudentsRepository;
import com.edgaritzak.gradeManagerSystem.repository.StudentRepository;
import com.edgaritzak.gradeManagerSystem.repository.SystemUserRepository;
import com.edgaritzak.gradeManagerSystem.repository.TeacherRepository;

@Service
public class SystemUserServiceImpl implements SystemUserService{
	
	SystemUserRepository systemUserRepo;
	InscriptionsStudentsRepository inscriptionsStudentsRepo;
	StudentRepository studentRepository;
	TeacherRepository teacherRepository;
	@Autowired
	public SystemUserServiceImpl(SystemUserRepository systemUserRepo,
			InscriptionsStudentsRepository inscriptionsStudentsRepo,StudentRepository studentRepository,
			TeacherRepository teacherRepository) {
		this.systemUserRepo = systemUserRepo;
		this.inscriptionsStudentsRepo = inscriptionsStudentsRepo;
		this.studentRepository = studentRepository;
		this.teacherRepository = teacherRepository;
	}
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	public SystemUser save(SystemUser systemUser) {
		return systemUserRepo.save(systemUser);
	}

	public void deleteById(int id) {
		systemUserRepo.deleteById(id);
	}
	
	@Override
	public SystemUser findByEmail(String email) {
		return systemUserRepo.findByEmail(email);
	}
	
	@Override
	public List<SystemUser> findStudentsByGroup(int groupId) {
		return systemUserRepo.findStudentsByGroup(groupId);
	}

	@Override
	public SystemUser findTeacherById(int teacherId) {
		SystemUser teacher = systemUserRepo.findTeacherById(teacherId)
				.orElseThrow(()->new NoSuchElementException("No value present"));
		return teacher;
	}

	@Override
	public SystemUser findStudentById(int studentId) {
		SystemUser student = systemUserRepo.findStudentById(studentId)
				.orElseThrow(()->new NoSuchElementException("No value present"));
		return student;
	}

	@Override
	public SystemUser findUserById(int userId) {
		SystemUser user = systemUserRepo.findUserById(userId)
				.orElseThrow(()->new NoSuchElementException("No value present"));
		return user;
	}
	
	//GETS A LIST WITH ALL STUDENTS IN A SPECIFIC GROUP(ID)
	@Override
	public List<StudentWithScoreDTO> findStudentsWithScoreByGroup(int groupId) {
		
		List<InscriptionsStudents> inscriptionsStudentsList = 
				inscriptionsStudentsRepo.findInscriptionsStudentsByGroupId(groupId);
		
		
		return inscriptionsStudentsList.stream()
				.map(e -> new StudentWithScoreDTO(
						e.getId(),
						e.getStudent().getId(),
						e.getStudent().getSystemUser().getFirstName(),
						e.getStudent().getSystemUser().getLastName(),
						(int)e.getScore()))
				.collect(Collectors.toList());
	}

	@Override
	public List<SystemUser> findAll() {
		return systemUserRepo.findAll();
	}
	
	//GETS A LIST WITH ALL STUDENTS-DTO
	public List<SystemUserWithRoleIdDTO> findAllStudentsDTO() {
		List<SystemUserWithRoleIdDTO> onlyStudents = new ArrayList<>();
		List<SystemUser> allUsers = systemUserRepo.findAll();
		for(SystemUser user: allUsers) {
			if(user.getStudent()!=null) {
				onlyStudents.add(new SystemUserWithRoleIdDTO(
						user.getId(),
						user.getFirstName(),
						user.getLastName(),
						user.getEmail(),
						user.getPassword(),
						user.getRole(),
						user.getStudent().getId()));
			}
		}
		return onlyStudents;
	}
	//GETS A LIST WITH ALL STUDENTS-DTO
	public List<SystemUserWithRoleIdDTO> findAllTeachersDTO() {
		List<SystemUserWithRoleIdDTO> onlyTeachers = new ArrayList<>();
		List<SystemUser> allUsers = systemUserRepo.findAll();
		for(SystemUser user: allUsers) {
			if(user.getTeacher()!=null) {
				onlyTeachers.add(new SystemUserWithRoleIdDTO(
						user.getId(),
						user.getFirstName(),
						user.getLastName(),
						user.getEmail(),
						user.getPassword(),
						user.getRole(),
						user.getTeacher().getId()));
			}
		}
		return onlyTeachers;
	}
}
