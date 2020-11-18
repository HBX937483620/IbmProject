package com.ibm.issue.service;

import static org.hamcrest.CoreMatchers.nullValue;

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
	
	

	public int verify(ReportWithBLOBs issue) {
		
		return 1;
	}


}
