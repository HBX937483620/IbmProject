package com.ibm.issue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.issue.dao.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper; 
	

}
