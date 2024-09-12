package com.edgaritzak.gradeManagerSystem.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgaritzak.gradeManagerSystem.service.GroupServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.InscriptionsStudentsServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.StudentServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.SystemUserServiceImpl;

@RestController
@RequestMapping("/teacher")
public class TeacherRESTController {
	
	private SystemUserServiceImpl systemUserServiceImpl;
	private StudentServiceImpl studentServiceImpl;
	private GroupServiceImpl groupServiceImpl;
	private InscriptionsStudentsServiceImpl inscriptionsStudentsServiceImpl;
	
	@Autowired
	public TeacherRESTController(SystemUserServiceImpl systemUserServiceImpl, StudentServiceImpl studentServiceImpl,
			GroupServiceImpl groupServiceImpl, InscriptionsStudentsServiceImpl inscriptionsStudentsServiceImpl) {
		super();
		this.systemUserServiceImpl = systemUserServiceImpl;
		this.studentServiceImpl = studentServiceImpl;
		this.groupServiceImpl = groupServiceImpl;
		this.inscriptionsStudentsServiceImpl = inscriptionsStudentsServiceImpl;
	}

	@GetMapping("/user")
    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
             if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            return "Your Email: " + username;
        }
        return "No user found";
    }
	
	@GetMapping("")
	public String teacherHome() {
		return "Teacher home";
	}
	
	@GetMapping("/mycourses")
	public String hello() {
		return "Hello";
	}
}
