package com.ibm.issue.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.issue.pojo.User;
import com.ibm.issue.service.UserService;



@RestController()
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUser")
	public User getUser(User user) {
		return userService.getUser();
	}
	
	
}
