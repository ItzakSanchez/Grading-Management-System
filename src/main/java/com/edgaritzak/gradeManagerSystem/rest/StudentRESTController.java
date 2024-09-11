package com.edgaritzak.gradeManagerSystem.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgaritzak.gradeManagerSystem.service.GroupServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.InscriptionsStudentsServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.StudentServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.SystemUserServiceImpl;

@RestController
@RequestMapping("/student")
public class StudentRESTController {
	
	private SystemUserServiceImpl systemUserServiceImpl;
	private StudentServiceImpl studentServiceImpl;
	private GroupServiceImpl groupServiceImpl;
	private InscriptionsStudentsServiceImpl inscriptionsStudentsServiceImpl;
	
	@Autowired
	public StudentRESTController(SystemUserServiceImpl systemUserServiceImpl, StudentServiceImpl studentServiceImpl,
			GroupServiceImpl groupServiceImpl, InscriptionsStudentsServiceImpl inscriptionsStudentsServiceImpl) {
		super();
		this.systemUserServiceImpl = systemUserServiceImpl;
		this.studentServiceImpl = studentServiceImpl;
		this.groupServiceImpl = groupServiceImpl;
		this.inscriptionsStudentsServiceImpl = inscriptionsStudentsServiceImpl;
	}

	@GetMapping("")
	public String studentHome() {
		return "Student home";
	}
	
	@GetMapping("/hi")
	public String hello() {
		return "Hello";
	}
}
