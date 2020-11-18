package com.ibm.issue.service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ibm.issue.dao.UserMapper;
import com.ibm.issue.pojo.User;
import com.ibm.issue.pojo.UserExample;
import com.ibm.issue.pojo.UserExample.Criteria;
import com.ibm.issue.pojo.UserPage;

@Service
public class AdminSercice {
	
	@Autowired
	private UserMapper userMapper;
	
	public String selectLikeByNameOrId(UserPage userPage) {
		PageHelper.startPage(userPage.getPage(),userPage.getRows());
		
		UserExample userExample = new UserExample();
		Criteria userCriteria = userExample.createCriteria();
		
		
		if (userPage.getUser().getUserid() != null) {
			userCriteria.andUseridLike("%"+userPage.getUser().getUserid()+"%");
		}
		if (userPage.getUser().getName() != null) {
			userCriteria.andNameLike("%"+userPage.getUser().getName()+"%");
		}
//		userCriteria.andUseridLike("%"+user.getUserid()+"%");
//		userCriteria.andNameLike("%"+user.getName()+"%");
		List<User> userFind = userMapper.selectByExample(userExample);
		
		String list = JSON.toJSONString(userFind);
        PageInfo info = new PageInfo<>(userFind);
        long total = info.getTotal();
        String json = "{\"total\":"+total+",\"rows\":"+list+" }";
		return json;
	}
	
	/**
	 * 将普通用户升级为经理
	 * @param user
	 * @return
	 */
	public Integer transToManager(User user) {
		UserExample userExample = new UserExample();
		Criteria createCriteria = userExample.createCriteria();
		createCriteria.andUseridEqualTo(user.getUserid());
		User permission = new User();
		permission.setPermission(2);	
		return userMapper.updateByExampleSelective(permission, userExample);

	}
	
	
	/**
	 * 将用户状态更改为注销
	 * @param user
	 * @return
	 */
	public Integer deleteUser(User user) {
		UserExample userExample = new UserExample();
		Criteria createCriteria = userExample.createCriteria();
		createCriteria.andUseridEqualTo(user.getUserid());
		User permission = new User();
		permission.setUserstate("注销");
		return userMapper.updateByExampleSelective(permission, userExample);
	}
}
