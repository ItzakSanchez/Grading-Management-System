package com.edgaritzak.gradeManagerSystem.service;

import com.edgaritzak.gradeManagerSystem.dto.SystemUserWithRoleIdDTO;

public interface SessionService {
	
	SystemUserWithRoleIdDTO findUserWithRoleDTOByEmail(String Email);
}
