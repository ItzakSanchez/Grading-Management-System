package com.edgaritzak.gradeManagerSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edgaritzak.gradeManagerSystem.dto.SystemUserWithRoleIdDTO;
import com.edgaritzak.gradeManagerSystem.service.UserSessionServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {

	@Autowired
	private UserSessionServiceImpl userSessionServiceImpl;
	
	@GetMapping("/login")
	public String siteHome(Model model, @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
		if (error != null) {
		model.addAttribute("error", "Invalid username or password.");
		}
		if (logout != null) {
		model.addAttribute("logout", "You have been logged out.");
		}
		return "login";
	}
	
	@GetMapping("/auth")
	public String authentification(HttpSession session) {	
		SystemUserWithRoleIdDTO user = userSessionServiceImpl.findUserWithRoleDTOByEmail(
				SecurityContextHolder.getContext().getAuthentication().getName());
		String userRole = user.getRole();
		
		//SESSION VARIABLES
		session.setAttribute("systemUserId", user.getId());
		session.setAttribute("firstName", user.getFirstName());
		session.setAttribute("lastName", user.getLastName());
		session.setAttribute("email", user.getEmail());
		session.setAttribute("password", user.getPassword());
		session.setAttribute("role", user.getRole());
		session.setAttribute("roleId", user.getRoleId());
		
		if(userRole.equals("STUDENT")) return "redirect:/student";
		if(userRole.equals("TEACHER")) return "redirect:/teacher";
		if(userRole.equals("ADMIN")) return "redirect:/admin";
		return "redirect:/error"; 
	}
	
	@ResponseBody
	@GetMapping("/error")
	public String error() {
		return "Welcome to error page";
	}
}
