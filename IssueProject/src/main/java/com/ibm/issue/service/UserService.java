package com.ibm.issue.service;




import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.issue.dao.UserMapper;
import com.ibm.issue.pojo.User;




@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	public User getUser() {
		System.out.println(System.currentTimeMillis());
		return userMapper.selectByPrimaryKey(1);
	}
}
