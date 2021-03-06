package com.ibm.issue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.issue.pojo.User;
import com.ibm.issue.pojo.UserPage;
import com.ibm.issue.service.AdminSercice;

@RestController
public class AdminController {
	@Autowired
	private AdminSercice adminSercice;
	
	
	
	@PostMapping("selectLikeByNameOrId")
	public String selectLikeByNameOrId(@RequestBody User user) {
		return adminSercice.selectLikeByNameOrId(user);
	}
	
	@RequestMapping(value = "findLikeByNameOrId")
	public String selectLikeByNameOrId(@RequestBody UserPage userPage) {
		return adminSercice.selectLikeByNameOrId(userPage);
	}
	
	@RequestMapping(value = "transToManager")
	public int transToManager(@RequestBody User user) {
		return adminSercice.transToManager(user);
	}
	
	@RequestMapping(value="deleteUser")
	public int deleteUser(@RequestBody User user) {
		return adminSercice.deleteUser(user);
	}
}
