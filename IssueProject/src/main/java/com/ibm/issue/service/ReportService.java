package com.ibm.issue.service;

//import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.alibaba.fastjson.JSON;
import com.ibm.issue.dao.ReportMapper;
import com.ibm.issue.dao.UserMapper;
import com.ibm.issue.pojo.Report;
import com.ibm.issue.pojo.ReportExample;
import com.ibm.issue.pojo.ReportWithBLOBs;
import com.ibm.issue.pojo.User;
import com.ibm.issue.pojo.UserExample;
import com.ibm.issue.pojo.ReportExample.Criteria;


@Service
public class ReportService {
	@Autowired
	private ReportMapper reportMapper;
	@Autowired
	private UserMapper userMapper;
	
/**
 * 创建人创建issue表
 * @param issue
 * @return
 */
	public Integer createReport(ReportWithBLOBs issue) {
	Date date = new Date(System.currentTimeMillis());
	issue.setCreatedate(date);
	Long currentTimeMillis = System.currentTimeMillis();
	String string = currentTimeMillis.toString();
	String issueid = string.substring(string.length()-6);
	issue.setIssueid(issueid);
	return reportMapper.insert(issue);
	}

	/**
	 * 点击详情查看issue報表
	 * @param issue
	 * @return
	 */
	public List<ReportWithBLOBs> details(ReportWithBLOBs issue) {
		ReportExample reportExample = new ReportExample();
		Criteria createCriteria = reportExample.createCriteria();
		createCriteria.andIssueidEqualTo(issue.getIssueid());
		return reportMapper.selectByExampleWithBLOBs(reportExample);		
	}
	
	
	/**
	 * 修改人填写解决方案
	 * @param issue
	 * @return
	 */
	public int solve(ReportWithBLOBs issue) {
		ReportExample reportExample = new ReportExample();
		Criteria criteria = reportExample.createCriteria();
		criteria.andIssueidEqualTo(issue.getIssueid());
		ReportWithBLOBs report = new ReportWithBLOBs();
		report.setSolution(issue.getSolution());
		report.setState(2);
		return reportMapper.updateByExampleSelective(report, reportExample);
	}
	

	/**
	 * 创建人决定是否退回修改
	 * @param issue
	 * @return
	 */
	public int verify(ReportWithBLOBs issue) {
		issue.getFlag();
		ReportExample reportExample = new ReportExample();
		Criteria criteria = reportExample.createCriteria();
		criteria.andIssueidEqualTo(issue.getIssueid());
		ReportWithBLOBs report = new ReportWithBLOBs();
		if(issue.getFlag().equals("1")) {
			report.setState(1);
		}else {
			Date date = new Date(System.currentTimeMillis());
			report.setEnddate(date);
			report.setState(3);
		}
		return reportMapper.updateByExampleSelective(report, reportExample);
	}
	
	//根据用户姓名ID查询
	public String queryByUserIdName(String[] a) {
		System.out.println("????????????????????");
		String userId=a[0];
		String userName=a[1];
		System.out.println(userId);
		System.out.println(userName);
		ReportExample reportExample = new ReportExample();
		com.ibm.issue.pojo.ReportExample.Criteria queryReport = reportExample.createCriteria();
		
		String jsonString="";
		if(userName!="") {
			System.out.println("执行1");
			userName="%"+userName+"%";
			queryReport.andCreatorLike(userName);
			List<Report> selectByExample = reportMapper.selectByExample(reportExample);
			jsonString=JSON.toJSONString(selectByExample);
		}
		else if(userId!="") {
			System.out.println("执行2");
			//根据Id模糊查询获得用户名
			userId="%"+userId+"%";
			System.out.println(userId);
			UserExample userExample=new UserExample();
			com.ibm.issue.pojo.UserExample.Criteria queryUser=userExample.createCriteria();
			queryUser.andUseridLike(userId);
			List<User> selectByExample = userMapper.selectByExample(userExample);
			for (User user : selectByExample) {
//				reportExample.clear();
				queryReport.andCreatorEqualTo(user.getName());
				
				System.out.println("准备找的名字"+user.getName());
				
				List<Report> selectByExample2 = reportMapper.selectByExample(reportExample);
				
				jsonString+=JSON.toJSONString(selectByExample2);
				
				System.out.println("草草草草草"+jsonString);
			}
		}
		return jsonString;
	}

//    //issue表模糊查询
//	public List<Report> queryReport(ReportWithBLOBs issue) {
//		String issueid = issue.getIssueid();
//		String creator = issue.getCreator();
//		String modifier = issue.getModifier();
//		int state = issue.getState();
//		java.util.Date createdate = issue.getCreatedate();
//		java.util.Date createdate2 = issue.getCreatedate();
//		java.util.Date endDate = issue.getEnddate();
//		java.util.Date endDate2 = issue.getEnddate();
//
//		ReportExample reportExample = new ReportExample();
//		com.ibm.issue.pojo.ReportExample.Criteria queryReport = reportExample.createCriteria();
//		if (issueid != "" || issueid != null) {
//			issueid = "%" + issue.getIssueid() + "%";
//			queryReport.andIssueidLike(issueid);
//		}
//		if (creator != "" || creator != null) {
//			creator = "%" + issue.getCreator() + "%";
//			queryReport.andCreatorLike(creator);
//		}
//		if (modifier != "" || modifier != null) {
//			modifier = "%" + issue.getModifier() + "%";
//			queryReport.andModifierLike(modifier);
//		}
//		/////////////////////
//		if (createdate != null && createdate2 != null) {
//			queryReport.andCreatedateBetween(createdate, createdate2);
//		}
//		else if (createdate == null && createdate2 != null) {
//			queryReport.andCreatedateLessThanOrEqualTo(createdate2);
//		}
//		else if(createdate!= null && createdate2 == null) {
//			queryReport.andCreatedateGreaterThanOrEqualTo(createdate);
//		}
//		////////////////////////////
//		if (endDate != null && endDate2 != null) {
//			queryReport.andCreatedateBetween(endDate, endDate2);
//		}
//		else if (endDate == null && endDate2 != null) {
//			queryReport.andCreatedateLessThanOrEqualTo(endDate2);
//		}
//		else if(endDate != null && endDate2 == null) {
//			queryReport.andCreatedateGreaterThanOrEqualTo(endDate);
//		}

//		queryReport.andStateEqualTo(state);

//
//		List<Report> selectByExample = reportMapper.selectByExample(reportExample);
//		return selectByExample;
//	}

}