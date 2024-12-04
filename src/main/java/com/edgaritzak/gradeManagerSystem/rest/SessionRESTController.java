package com.edgaritzak.gradeManagerSystem.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SessionRESTController {

	
	
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
	
	
	@ResponseBody
	@GetMapping("/hi")
	public String hello() {
		return "Hello";
	}
}
