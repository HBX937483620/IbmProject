package com.ibm.issue.controller;

import java.sql.Date;

import org.apache.ibatis.javassist.expr.NewArray;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.issue.dao.UserMapper;
import com.ibm.issue.pojo.User;

@RestController
public class test {
	@Autowired
	private UserMapper userMapper; 
	
	@Test
	public String Test() {
		User user = new User();
		Date date = new Date(0);
		user.setEmail("dgjsdsakj@qwe.com");
		user.setName("sadas");
		user.setPassword("sdasdsad");
		user.setUserid("asdsad");
		user.setSignup(date);
		userMapper.insert(user);
		return "hello";
	}
}
