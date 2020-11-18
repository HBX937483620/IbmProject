package com.ibm.issue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.ibm.issue.dao.UserAndIdentityMapper;
import com.ibm.issue.pojo.User;
import com.ibm.issue.pojo.UserPage;


@RestController
public class Test {
	
	@Autowired
	private UserAndIdentityMapper mapper;
	
	@PostMapping("select")
	public String selectLikeByNameOrId(@RequestBody UserPage user) {
		PageHelper.startPage(1,1);
		List<User> a = mapper.findUserAndIdentity(user);
		String list = JSON.toJSONString(a);
		return list;
	}
}
