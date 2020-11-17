package com.ibm.issue.service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.ibm.issue.dao.ReportMapper;
import com.ibm.issue.pojo.IdentityExample.Criteria;
import com.ibm.issue.pojo.Report;
import com.ibm.issue.pojo.ReportWithBLOBs;

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
	reportMapper.insert(issue);	
	return reportMapper.insert(issue);
	}

	
	public Report updateReport(ReportWithBLOBs issue) {
		
		return null;		
	}
//public Report getReport() {
//	 TODO Auto-generated method stub
//	return reportMapper.selectByPrimaryKey(1);
//}


}
