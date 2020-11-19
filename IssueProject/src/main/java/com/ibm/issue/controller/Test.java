package com.ibm.issue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.ibm.issue.dao.UserAndIdentityMapper;
import com.ibm.issue.dao.UserMapper;
import com.ibm.issue.pojo.ReportWithBLOBs;
import com.ibm.issue.pojo.User;
import com.ibm.issue.pojo.UserExample;
import com.ibm.issue.pojo.UserExample.Criteria;
import com.ibm.issue.pojo.UserPage;


@RestController
public class Test {
	
	@Autowired
	private UserAndIdentityMapper mapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@PostMapping("test")
	public List<User> selectLikeByNameOrId(@RequestBody User user) {
		UserExample userExample = new UserExample();
		Criteria userCriteria = userExample.createCriteria();
		
		
		if (user.getUserid() != null) {
			userCriteria.andUseridLike("%"+user.getUserid()+"%");
		}
		if (user.getName() != null) {
			userCriteria.andNameLike("%"+user.getName()+"%");
		}
		return userMapper.selectByExample(userExample);
	}
	
	@PostMapping("findReport")
	public List<ReportWithBLOBs> findReport(@RequestBody ReportWithBLOBs r) {
		System.out.println(r.getCreateStartDate());
		return mapper.findReportAndState(r);
	}
}
