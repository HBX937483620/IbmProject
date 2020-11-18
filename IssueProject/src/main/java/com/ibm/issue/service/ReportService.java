package com.ibm.issue.service;

//import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.ibm.issue.dao.ReportMapper;
import com.ibm.issue.pojo.Report;
import com.ibm.issue.pojo.ReportExample;
import com.ibm.issue.pojo.ReportWithBLOBs;
import com.ibm.issue.pojo.ReportExample.Criteria;


@Service
public class ReportService {
	@Autowired
	private ReportMapper reportMapper;
	
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
	issue.setPlandate(date);    //后面记得改这个planDate
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
	
	public ReportWithBLOBs solve(ReportWithBLOBs issue) {
		
		return null;
	}
	
//	issue表模糊查询
	public List<Report> queryReport(ReportWithBLOBs issue) {
		String issueid = issue.getIssueid();
		String creator = issue.getCreator();
		String modifier = issue.getModifier();
		int state = issue.getState();
		java.util.Date createdate = issue.getCreatedate();
		java.util.Date createdate2 = issue.getCreatedate();
		java.util.Date endDate = issue.getEnddate();
		java.util.Date endDate2 = issue.getEnddate();

		ReportExample reportExample = new ReportExample();
		com.ibm.issue.pojo.ReportExample.Criteria queryReport = reportExample.createCriteria();
		if (issueid != "" || issueid != null) {
			issueid = "%" + issue.getIssueid() + "%";
			queryReport.andIssueidLike(issueid);
		}
		if (creator != "" || creator != null) {
			creator = "%" + issue.getCreator() + "%";
			queryReport.andCreatorLike(creator);
		}
		if (modifier != "" || modifier != null) {
			modifier = "%" + issue.getModifier() + "%";
			queryReport.andModifierLike(modifier);
		}
		/////////////////////
		if (createdate != null && createdate2 != null) {
			queryReport.andCreatedateBetween(createdate, createdate2);
		}
		if (createdate == null && createdate2 != null) {
			queryReport.andCreatedateLessThanOrEqualTo(createdate2);
		}
		if (createdate != null && createdate2 == null) {
			queryReport.andCreatedateGreaterThanOrEqualTo(createdate);
		}
		////////////////////////////
		if (endDate != null && endDate2 != null) {
			queryReport.andCreatedateBetween(endDate, endDate2);
		}
		if (endDate == null && endDate2 != null) {
			queryReport.andCreatedateLessThanOrEqualTo(endDate2);
		}
		if (endDate != null && endDate2 == null) {
			queryReport.andCreatedateGreaterThanOrEqualTo(endDate);
		}
		////////////////////////////
		queryReport.andStateEqualTo(state);

		List<Report> selectByExample = reportMapper.selectByExample(reportExample);
		return selectByExample;
	}

}