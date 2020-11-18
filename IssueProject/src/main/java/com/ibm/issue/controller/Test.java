package com.ibm.issue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.issue.dao.UserAndIdentityMapper;
import com.ibm.issue.pojo.User;


@RestController
public class Test {
	
	@Autowired
	private UserAndIdentityMapper mapper;
	
	
	@GetMapping(value = "/select")
	public List<User> selectLikeByNameOrId() {
		return mapper.findUserAndIdentity();
	}
}
