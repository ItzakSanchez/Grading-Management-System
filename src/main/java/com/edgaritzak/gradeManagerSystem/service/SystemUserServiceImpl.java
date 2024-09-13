package com.edgaritzak.gradeManagerSystem.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgaritzak.gradeManagerSystem.dto.StudentWithScoreDTO;
import com.edgaritzak.gradeManagerSystem.entity.InscriptionsStudents;
import com.edgaritzak.gradeManagerSystem.entity.SystemUser;
import com.edgaritzak.gradeManagerSystem.repository.InscriptionsStudentsRepository;
import com.edgaritzak.gradeManagerSystem.repository.SystemUserRepository;

@Service
public class SystemUserServiceImpl implements SystemUserService{
	
	SystemUserRepository systemUserRepo;
	InscriptionsStudentsRepository inscriptionsStudentsRepo;
	@Autowired
	public SystemUserServiceImpl(SystemUserRepository systemUserRepo,
			InscriptionsStudentsRepository inscriptionsStudentsRepo) {
		this.systemUserRepo = systemUserRepo;
		this.inscriptionsStudentsRepo = inscriptionsStudentsRepo;
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
						e.getStudent().getId(),
						e.getStudent().getSystemUser().getFirstName(),
						e.getStudent().getSystemUser().getLastName(),
						e.getScore()))
				.collect(Collectors.toList());
	}

	@Override
	public List<SystemUser> findAll() {
		return systemUserRepo.findAll();
	}
	
	
}
