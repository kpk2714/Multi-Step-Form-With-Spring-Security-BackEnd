package com.multi.step.form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.multi.step.form.entities.User;
import com.multi.step.form.service.CustomUserDetailsService;
import com.multi.step.form.service.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class RegisterController {
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public User save(@RequestBody User user){
		
		user.setStudentId(userService.generateStudentId());
		return this.userDetailsService.saveUser(user);
	}
}
