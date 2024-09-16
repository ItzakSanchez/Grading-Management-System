package com.edgaritzak.gradeManagerSystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.edgaritzak.gradeManagerSystem.dto.CourseGroupWithScoreDTO;
import com.edgaritzak.gradeManagerSystem.service.GroupServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentController {
	

	private GroupServiceImpl groupServiceImpl;	
	@Autowired
	public StudentController(GroupServiceImpl groupServiceImpl) {
		this.groupServiceImpl = groupServiceImpl;
	}
	
	
	@GetMapping("/userDetails")
    public String userDetails(Model model, HttpSession session) {
		Map<String, Object> attributes = new HashMap<>();
		
		attributes.put("systemUserId", session.getAttribute("systemUserId"));
		attributes.put("firstName", session.getAttribute("firstName"));
		attributes.put("lastName", session.getAttribute("lastName"));
		attributes.put("email", session.getAttribute("email"));
		attributes.put("password", session.getAttribute("password"));
		attributes.put("role", session.getAttribute("role"));
		attributes.put("roleId", session.getAttribute("roleId"));
		model.addAttribute("userAttributes", attributes);
		
		return "userDetails";
    }
	
	
	@GetMapping("")
	public String studentGroup(Model model, HttpSession session) {
		Map<String, Object> attributes = new HashMap<>();
	
		attributes.put("systemUserId", session.getAttribute("systemUserId"));
		attributes.put("firstName", session.getAttribute("firstName"));
		attributes.put("lastName", session.getAttribute("lastName"));
		attributes.put("email", session.getAttribute("email"));
		attributes.put("password", session.getAttribute("password"));
		attributes.put("role", session.getAttribute("role"));
		attributes.put("roleId", session.getAttribute("roleId"));
		model.addAttribute("userAttributes", attributes);
		
		List<CourseGroupWithScoreDTO> groupList = 
				groupServiceImpl.findStudentsCourseGroupWithScoreDTO(
						(Integer)session.getAttribute("roleId"));
		model.addAttribute("groupList", groupList);
		
		if (groupList.isEmpty()) {
            model.addAttribute("emptyGroupMessage", "No groups found.");
        }
		
		return "studentGroup";
	}
	
}
