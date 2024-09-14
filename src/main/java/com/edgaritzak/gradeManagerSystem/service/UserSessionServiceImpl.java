package com.edgaritzak.gradeManagerSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edgaritzak.gradeManagerSystem.dto.SystemUserWithRoleIdDTO;
import com.edgaritzak.gradeManagerSystem.entity.SystemUser;
import com.edgaritzak.gradeManagerSystem.repository.SystemUserRepository;

@Service
public class UserSessionServiceImpl implements SessionService {

	
	private SystemUserRepository systemUserRepo;
	@Autowired
	public UserSessionServiceImpl(SystemUserRepository systemUserRepo) {
		this.systemUserRepo = systemUserRepo;
	}
	
	//SYSTEMUSER TRANSFORM  DTO (BY EMAIL)
	@Override
	public SystemUserWithRoleIdDTO findUserWithRoleDTOByEmail(String email) {
		SystemUser tempUser = systemUserRepo.findByEmail(email);
		int roleId = 0;
		if (tempUser.getRole().equals("STUDENT")) roleId = tempUser.getStudent().getId();
		if (tempUser.getRole().equals("TEACHER")) roleId = tempUser.getTeacher().getId();
		if (tempUser.getRole().equals("ADMIN")) roleId = tempUser.getAdmin().getId();
		SystemUserWithRoleIdDTO user = new SystemUserWithRoleIdDTO(
				tempUser.getId(),
				tempUser.getFirstName(),
				tempUser.getLastName(),
				tempUser.getEmail(),
				tempUser.getPassword(),
				tempUser.getRole(),
				roleId
				);
		return user;
	}

	public SystemUserWithRoleIdDTO findUserWithRoleDTOBySystemId(int id) {
		SystemUser tempUser = systemUserRepo.findById(id).get();
		int roleId = 0;
		if (tempUser.getRole().equals("STUDENT")) roleId = tempUser.getStudent().getId();
		if (tempUser.getRole().equals("TEACHER")) roleId = tempUser.getTeacher().getId();
		SystemUserWithRoleIdDTO user = new SystemUserWithRoleIdDTO(
				tempUser.getId(),
				tempUser.getFirstName(),
				tempUser.getLastName(),
				tempUser.getEmail(),
				tempUser.getPassword(),
				tempUser.getRole(),
				roleId
				);
		return user;
	}
}
