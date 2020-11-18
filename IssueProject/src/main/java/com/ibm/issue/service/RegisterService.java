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
	/**
	 * 登录功能实现（用户是否存在，是否为激活状态，密码是否正确）
	 * @param user
	 * @return
	 */
	public String login(User user) {
		//查询用户信息
		String flag;
		UserExample userExample = new UserExample();
		Criteria userLogIn = userExample.createCriteria();
		userLogIn.andUseridEqualTo(user.getUserid());
		List<User> userFind = userMapper.selectByExample(userExample);
		
		
		//判断是否为空
		if (userFind.isEmpty()) {
			flag="0";
			return flag;
		}else {
			
			String password = userFind.get(0).getPassword();  //正确的密码
			String inputPassword = user.getPassword();   //用户输入的密码
			String userstate = userFind.get(0).getUserstate();  //用户状态
			System.out.println(userstate);
			//判断密码是否正确和状态是否为激活
			if (password.equals(inputPassword) && userstate.equalsIgnoreCase("激活")){
				flag = "1";
				return "{\"name\":\"" +userFind.get(0).getName()+ "\",\"permission\":\""
			+userFind.get(0).getPermission()+"\",\"flag\":\""+flag+"\"}";
			}else if (password.equals(inputPassword) && userstate.equalsIgnoreCase("注销")) {
				flag="2";
				return flag;
			}else {
				flag="-1";
				return flag;
			}
		}
		
		
		
	}
}
