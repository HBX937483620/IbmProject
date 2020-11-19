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
import com.ibm.issue.dao.ReportMapper;
import com.ibm.issue.dao.UserAndIdentityMapper;
import com.ibm.issue.dao.UserMapper;
import com.ibm.issue.pojo.ReportPage;
import com.ibm.issue.pojo.ReportWithBLOBs;
import com.ibm.issue.pojo.User;
import com.ibm.issue.pojo.UserExample;
import com.ibm.issue.pojo.UserExample.Criteria;
import com.ibm.issue.pojo.UserPage;
import com.ibm.issue.service.ReportService;


@RestController
public class ReportSelectController {
	
	@Autowired
	private UserAndIdentityMapper mapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ReportService reportService;
	
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

	/**
	 * issue报表直接模糊查询
	 * @param r
	 * @return
	 */
	@PostMapping("findReport")
	public List<ReportPage> findReport(@RequestBody ReportPage r) {
		return mapper.findReportAndState(r);
	}
	
	/**
	 * issue报表分页模糊查询
	 * @param r
	 * @return
	 */
	@PostMapping("findReport2")
	public String findReport2(@RequestBody ReportPage r) {
		return reportService.selectLikeByReport(r);
	}
}
