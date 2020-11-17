package com.ibm.issue.service;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.issue.dao.UserMapper;
import com.ibm.issue.pojo.User;
import com.ibm.issue.pojo.UserExample;
import com.ibm.issue.pojo.UserExample.Criteria;


@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public User getUser() {
		System.out.println(System.currentTimeMillis());
		return userMapper.selectByPrimaryKey(1);
	}
	
	
	public User updateUser(User user) {
		UserExample userExample = new UserExample();
		Criteria updateUser = userExample.createCriteria();
		updateUser.andUseridEqualTo(user.getUserid());
		List<User> selectByExample = userMapper.selectByExample(userExample);
		return null;
	}
}
