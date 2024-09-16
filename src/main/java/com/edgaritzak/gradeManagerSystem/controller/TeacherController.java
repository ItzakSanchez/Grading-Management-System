package com.edgaritzak.gradeManagerSystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.edgaritzak.gradeManagerSystem.dto.GroupWithCourseDTO;
import com.edgaritzak.gradeManagerSystem.dto.StudentWithScoreDTO;
import com.edgaritzak.gradeManagerSystem.service.GroupServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.InscriptionsStudentsServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.SystemUserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	private SystemUserServiceImpl systemUserServiceImpl;
	private GroupServiceImpl groupServiceImpl;
	private InscriptionsStudentsServiceImpl inscriptionsStudentsServiceImpl;
	
	@Autowired
	public TeacherController(SystemUserServiceImpl systemUserServiceImpl,
			GroupServiceImpl groupServiceImpl, InscriptionsStudentsServiceImpl inscriptionsStudentsServiceImpl) {
		super();
		this.systemUserServiceImpl = systemUserServiceImpl;
		this.groupServiceImpl = groupServiceImpl;
		this.inscriptionsStudentsServiceImpl = inscriptionsStudentsServiceImpl;
	}

	
	@GetMapping("")
	public String teacherGroup(Model model, HttpSession session) {
		Map<String, Object> attributes = new HashMap<>();
		
		attributes.put("systemUserId", session.getAttribute("systemUserId"));
		attributes.put("firstName", session.getAttribute("firstName"));
		attributes.put("lastName", session.getAttribute("lastName"));
		attributes.put("email", session.getAttribute("email"));
		attributes.put("password", session.getAttribute("password"));
		attributes.put("role", session.getAttribute("role"));
		attributes.put("roleId", session.getAttribute("roleId"));
		model.addAttribute("userAttributes", attributes);
		
		List<GroupWithCourseDTO> groupList = 
				groupServiceImpl.findTeachersGroupWithCourseDTO(
						(Integer)session.getAttribute("roleId"));
		model.addAttribute("groupList", groupList);
		
		if (groupList.isEmpty()) {
            model.addAttribute("emptyGroupMessage", "No groups found.");
        }
		return "teacherGroup";
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
	
	@GetMapping("/groupDetails")
	public String showGroupStudents(@RequestParam("groupId") int groupId, Model model) {
		Map<String, Object> courseAttributes = new HashMap<>();
		GroupWithCourseDTO group = groupServiceImpl.findGroupWithCourseDTOByGroupId(groupId);
		courseAttributes.put("groupId", group.getGroupId());
		courseAttributes.put("courseName", group.getCourseName());
		courseAttributes.put("description", group.getDescription());
		courseAttributes.put("semester", group.getSemester());
		courseAttributes.put("year", group.getYear());
		model.addAttribute("courseAttributes", courseAttributes);
		
		
		List<StudentWithScoreDTO> studentList = systemUserServiceImpl.findStudentsWithScoreByGroup(groupId);
		model.addAttribute("studentList", studentList);
		if (studentList.isEmpty()) {
            model.addAttribute("emptyGroupMessage", "No students found.");
        }

		return "groupDetails";
	}
	
	@GetMapping("/updateGroupDetails")
	public String updateGroupStudents(@RequestParam("groupId") int groupId, Model model) {
		Map<String, Object> courseAttributes = new HashMap<>();
		GroupWithCourseDTO group = groupServiceImpl.findGroupWithCourseDTOByGroupId(groupId);
		courseAttributes.put("groupId", group.getGroupId());
		courseAttributes.put("courseName", group.getCourseName());
		courseAttributes.put("description", group.getDescription());
		courseAttributes.put("semester", group.getSemester());
		courseAttributes.put("year", group.getYear());
		model.addAttribute("courseAttributes", courseAttributes);
		
		
		List<StudentWithScoreDTO> studentList = systemUserServiceImpl.findStudentsWithScoreByGroup(groupId);
		model.addAttribute("studentList", studentList);
		if (studentList.isEmpty()) {
            model.addAttribute("emptyGroupMessage", "No students found.");
        }

		return "updateGroupDetails";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam Map<String, String> params, @RequestParam("groupId")String groupId) {
		System.out.println("TEST");
		Map<Integer, Integer> valuesToUpdate = new HashMap<>();
		for (String key : params.keySet()) {
	        if (key.startsWith("score-")) {
	        	Integer idIncription = Integer.valueOf(key.substring("score-".length()));
	            double doubleScore = Double.valueOf(params.get(key));
	            Integer score = (int)doubleScore;
	            //ADD VALUES TO UPDATE (ID) (SCORE)
	            valuesToUpdate.put(idIncription, score);
	        }
	    }
		//UPDATE
		inscriptionsStudentsServiceImpl.updateScores(valuesToUpdate);
		return "redirect:/teacher/groupDetails?groupId="+groupId;
	}
}
