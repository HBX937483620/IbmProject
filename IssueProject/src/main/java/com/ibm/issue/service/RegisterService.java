package com.ibm.issue.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.issue.dao.UserMapper;
import com.ibm.issue.pojo.User;
import com.ibm.issue.pojo.UserExample;
import com.ibm.issue.pojo.UserExample.Criteria;

@Service
public class RegisterService {
	@Autowired
	private UserMapper userMapper;
	
	public Integer login(User user) {
		Date date = new Date(System.currentTimeMillis());
		user.setSignup(date);
		int result = userMapper.insert(user);
		return result;
	}
}
