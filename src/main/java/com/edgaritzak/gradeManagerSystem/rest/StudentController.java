package com.edgaritzak.gradeManagerSystem.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.edgaritzak.gradeManagerSystem.dto.GroupWithCourseDTO;
import com.edgaritzak.gradeManagerSystem.service.GroupServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.InscriptionsStudentsServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.StudentServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.SystemUserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	private SystemUserServiceImpl systemUserServiceImpl;
	private StudentServiceImpl studentServiceImpl;
	private GroupServiceImpl groupServiceImpl;
	private InscriptionsStudentsServiceImpl inscriptionsStudentsServiceImpl;
	
	@Autowired
	public StudentController(SystemUserServiceImpl systemUserServiceImpl, StudentServiceImpl studentServiceImpl,
			GroupServiceImpl groupServiceImpl, InscriptionsStudentsServiceImpl inscriptionsStudentsServiceImpl) {
		super();
		this.systemUserServiceImpl = systemUserServiceImpl;
		this.studentServiceImpl = studentServiceImpl;
		this.groupServiceImpl = groupServiceImpl;
		this.inscriptionsStudentsServiceImpl = inscriptionsStudentsServiceImpl;
	}
	
	
	@ResponseBody
	@GetMapping("/user")
    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
             if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            return "Your Email: " + username;
        }
        return "student";
    }
	
	
	@GetMapping("")
	public String studentHome(Model model, HttpSession session) {
		Map<String, Object> attributes = new HashMap<>();
	
		attributes.put("systemUserId", session.getAttribute("systemUserId"));
		attributes.put("firstName", session.getAttribute("firstName"));
		attributes.put("lastName", session.getAttribute("lastName"));
		attributes.put("email", session.getAttribute("email"));
		attributes.put("password", session.getAttribute("password"));
		attributes.put("role", session.getAttribute("role"));
		attributes.put("roleId", session.getAttribute("roleId"));
		model.addAttribute("userAtributes", attributes);
		
		List<GroupWithCourseDTO> groupList = 
				groupServiceImpl.findStudentsGroupWithCourseDTO(
						(Integer)session.getAttribute("roleId"));
		model.addAttribute("groupList", groupList);
		
		if (groupList.isEmpty()) {
            model.addAttribute("emptyGroupMessage", "No groups found.");
        }
		
		return "studentGroup";
	}
	
	
	@GetMapping("/home")
    public String hello() {
        return "student";
    }
}
