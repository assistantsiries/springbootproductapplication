package com.jspiders.weje3springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jspiders.weje3springboot.pojo.UserEntity;
import com.jspiders.weje3springboot.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@GetMapping("/signup")
	public String getSignup(ModelMap map) {
	 
		map.addAttribute("user", new UserEntity());
		
		return "signup";
		
	}
	

}
