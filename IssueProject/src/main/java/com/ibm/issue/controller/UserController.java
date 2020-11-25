package com.ibm.issue.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.issue.pojo.User;
import com.ibm.issue.service.UserService;



@RestController()
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/getUser")
	public String getUser(@RequestBody User user) {
		return userService.getUser(user);
	}
	
	@PostMapping("/getAll")
	public String getAll() {
		return userService.getAll();
	}
	
	@PostMapping("/updateUser")
	public Integer updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@PostMapping("/getUserInfo")
	public User getUpdateUser(@RequestBody User user) {
		return userService.getUpdateUser(user);
	}
	
	@PostMapping("/getUserPic")
	public String getUserPic(@RequestParam(value = "userid")String userid,
			@RequestParam(value = "file",required = false)MultipartFile file) {
		return userService.getUserPic(userid,file);
	}
	
	
	
	
}
