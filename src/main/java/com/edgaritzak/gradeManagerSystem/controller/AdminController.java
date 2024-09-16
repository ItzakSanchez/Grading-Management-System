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
import com.edgaritzak.gradeManagerSystem.dto.SystemUserWithRoleIdDTO;
import com.edgaritzak.gradeManagerSystem.entity.Course;
import com.edgaritzak.gradeManagerSystem.entity.Student;
import com.edgaritzak.gradeManagerSystem.entity.SystemUser;
import com.edgaritzak.gradeManagerSystem.entity.Teacher;
import com.edgaritzak.gradeManagerSystem.security.SecurityConfig;
import com.edgaritzak.gradeManagerSystem.service.GroupServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.InscriptionsStudentsServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.StudentServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.SystemUserServiceImpl;
import com.edgaritzak.gradeManagerSystem.service.UserSessionServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
    private SecurityConfig securityConfig;
	
	private UserSessionServiceImpl userSessionServiceImpl;
	private SystemUserServiceImpl systemUserServiceImpl;
	private GroupServiceImpl groupServiceImpl;
	
	@Autowired
	public AdminController(SystemUserServiceImpl systemUserServiceImpl, StudentServiceImpl studentServiceImpl,
			GroupServiceImpl groupServiceImpl, InscriptionsStudentsServiceImpl inscriptionsStudentsServiceImpl,
			UserSessionServiceImpl userSessionServiceImpl) {
		super();
		this.systemUserServiceImpl = systemUserServiceImpl;
		this.groupServiceImpl = groupServiceImpl;
		this.userSessionServiceImpl = userSessionServiceImpl;
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
		
		return "adminHome";
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
	
	@GetMapping("/courseList")
	public String showCourseList(Model model) {
		List<Course> courseList = groupServiceImpl.findAllCourses();
		model.addAttribute("courseList", courseList);
		if (courseList.isEmpty()) {
            model.addAttribute("emptyGroupMessage", "No courses found.");
        }
		return "adminCourseList";
	}
	@GetMapping("/groupList")
	public String showGroupList(Model model) {
		List<GroupWithCourseDTO> groupList = groupServiceImpl.findAllGroupWithCourseDTO();
		model.addAttribute("groupList", groupList);
		if (groupList.isEmpty()) {
            model.addAttribute("emptyGroupMessage", "No group found.");
        }
		return "adminGroupList";
	}
	
	
//	
//	STUDENT
//	
	
	@GetMapping("/studentList")
	public String showGroupStudents(Model model) {
		List<SystemUserWithRoleIdDTO> studentList = systemUserServiceImpl.findAllStudentsDTO();
		model.addAttribute("studentList", studentList);
		if (studentList.isEmpty()) {
            model.addAttribute("emptyGroupMessage", "No students found.");
        }
		return "adminStudentList";
	}
	
	@GetMapping("/createStudent")
	public String createStudents(Model model) {
		List<SystemUserWithRoleIdDTO> studentList = systemUserServiceImpl.findAllStudentsDTO();
		model.addAttribute("studentList", studentList);
		if (studentList.isEmpty()) {
            model.addAttribute("emptyGroupMessage", "No students found.");
        }
		return "adminNewStudent";
	}
	
	@PostMapping("/createStudent/save")
	public String saveNewStudents(@RequestParam("firstName")String firstName,
			@RequestParam("lastName")String lastName, @RequestParam("email")String email,
			@RequestParam("password")String password) {		
		
		
		securityConfig.removeUsers();
		
		SystemUser user =systemUserServiceImpl.save(new SystemUser(0,firstName,lastName,email,password,"STUDENT", null, null, null));
		user.setStudent(systemUserServiceImpl.saveStudent(new Student(0,user,null)));
		systemUserServiceImpl.save(user);
		securityConfig.updateUsers();

		return "redirect:/admin/studentList";
	}
	
	
	@GetMapping("/editStudent")
	public String updateStudent(@RequestParam("id") int id, Model model) {
			SystemUserWithRoleIdDTO student = userSessionServiceImpl.findUserWithRoleDTOBySystemId(id);
			model.addAttribute("student",student);
		return "adminEditStudent";
	}
	
	@PostMapping("/editStudent/updateStudent")
	public String update(@RequestParam("id")String id, @RequestParam("firstName")String firstName,
			@RequestParam("lastName")String lastName, @RequestParam("email")String email,
			@RequestParam("password")String password) {
		
		int idInt = Integer.parseInt(id);
		SystemUser user =systemUserServiceImpl.findUserById(idInt);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		
		
		//UPDATE
		securityConfig.removeUsers();
		systemUserServiceImpl.save(user);
		securityConfig.updateUsers();

		return "redirect:/admin/studentList";
	}
	
	@PostMapping("/deleteStudent")
	public String update(@RequestParam("id")String id) {
		
		int idInt = Integer.parseInt(id);
		
		//Delete Students Groups
		groupServiceImpl.deleteAllInscriptiosByStudentId(idInt);
		securityConfig.removeUsers();
		//Delete Student
		systemUserServiceImpl.deleteById(idInt);
		securityConfig.updateUsers();

		return "redirect:/admin/studentList";
	}
	
	
	
//
//TEACHER
//
	
	
	
	@GetMapping("/teacherList")
	public String showTeachersList(Model model) {
		List<SystemUserWithRoleIdDTO> teacherList = systemUserServiceImpl.findAllTeachersDTO();
		model.addAttribute("teacherList", teacherList);
		if (teacherList.isEmpty()) {
            model.addAttribute("emptyGroupMessage", "No teachers found.");
        }
		return "adminTeacherList";
	}
	
	@GetMapping("/createTeacher")
	public String createTeachers(Model model) {
		List<SystemUserWithRoleIdDTO> teacherList = systemUserServiceImpl.findAllStudentsDTO();
		model.addAttribute("teacherList", teacherList);
		if (teacherList.isEmpty()) {
            model.addAttribute("emptyGroupMessage", "No teachers found.");
        }
		return "adminNewTeacher";
	}
	
	@PostMapping("/createTeacher/save")
	public String saveNewTeacher(@RequestParam("firstName")String firstName,
			@RequestParam("lastName")String lastName, @RequestParam("email")String email,
			@RequestParam("password")String password) {		
		securityConfig.removeUsers();
		//SAVE
		SystemUser user =systemUserServiceImpl.save(new SystemUser(0,firstName,lastName,email,password,"TEACHER", null, null, null));
		user.setTeacher(systemUserServiceImpl.saveTeacher(new Teacher(0,user,null)));
		systemUserServiceImpl.save(user);
		securityConfig.updateUsers();
		return "redirect:/admin/teacherList";
	}
	
	
	@GetMapping("/editTeacher")
	public String updateTeacher(@RequestParam("id") int id, Model model) {
			SystemUserWithRoleIdDTO teacher = userSessionServiceImpl.findUserWithRoleDTOBySystemId(id);
			model.addAttribute("teacher",teacher);
		return "adminEditTeacher";
	}
	
	@PostMapping("/editTeacher/updateTeacher")
	public String updateTeacher(@RequestParam("id")String id, @RequestParam("firstName")String firstName,
			@RequestParam("lastName")String lastName, @RequestParam("email")String email,
			@RequestParam("password")String password) {
		
		int idInt = Integer.parseInt(id);
		SystemUser user =systemUserServiceImpl.findUserById(idInt);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		//UPDATE
		securityConfig.removeUsers();
		systemUserServiceImpl.save(user);
		securityConfig.updateUsers();
		return "redirect:/admin/teacherList";
	}
	
}