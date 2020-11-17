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
public class RegisterService {
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 注册功能
	 * @param user
	 * @return
	 */
	public Integer register(User user) {
		Date date = new Date(System.currentTimeMillis());
		user.setSignup(date);
		int result = userMapper.insert(user);
		return result;
	}
	
	/**
	 * 查询userid（账号）是否存在
	 * @param user
	 * @return
	 */
	public Boolean isExistId(User user) {
		UserExample userExample = new UserExample();
		Criteria createCriteria = userExample.createCriteria();
		createCriteria.andUseridEqualTo(user.getUserid());
		List<User> isExist = userMapper.selectByExample(userExample);
		return isExist.isEmpty();
	}
	
//	public Boolean login(User user) {
//		UserExample userExample = new UserExample();
//		Criteria userLogIn = userExample.createCriteria();
//		userLogIn.andUseridEqualTo(user.getUserid());
//		List<User> userFind = userMapper.selectByExample(userExample);
//		
//		userFind.get(0).getPassword() == user.getPassword();
//		return true;
//	}
}
