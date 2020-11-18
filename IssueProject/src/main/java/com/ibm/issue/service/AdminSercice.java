package com.ibm.issue.service;

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
	
	public Integer transToManager(User user) {
		
		User selectByPrimaryKey = userMapper.selectByPrimaryKey(user.getId());
		selectByPrimaryKey.setPermission(2);
		int updateByPrimaryKey = userMapper.updateByPrimaryKey(selectByPrimaryKey);
		
		return updateByPrimaryKey;
	}
	
	public Integer deleteUser(User user) {
		int deleteByPrimaryKey = userMapper.deleteByPrimaryKey(user.getId());
		return deleteByPrimaryKey;
	}
}
