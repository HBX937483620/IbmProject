package com.ibm.issue.service;



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
	
	/**
	 * 用于测试是否成功返回数据
	 * @return
	 */
	public User getUser() {
		System.out.println(System.currentTimeMillis());
		return userMapper.selectByPrimaryKey(1);
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public Integer updateUser(User user) {
		UserExample userExample = new UserExample();
		Criteria updateUser = userExample.createCriteria();
		updateUser.andUseridEqualTo(user.getUserid());
		
		//执行修改语句保存到数据库
		int isUpdate = userMapper.updateByExampleSelective(user, userExample);
		return isUpdate;
		
		
		//查询原用户信息
//		List<User> userFind = userMapper.selectByExample(userExample);
//		User userGet = userFind.get(0);		
		//修改
//		if (user.getName() != null) {
//			userGet.setName(user.getName());
//		}
//		if (user.getEmail() != null) {
//			userGet.setEmail(user.getEmail());
//		}
//		if (user.getPassword() != null) {
//			userGet.setPassword(user.getPassword());
//		}
		
	}
}
