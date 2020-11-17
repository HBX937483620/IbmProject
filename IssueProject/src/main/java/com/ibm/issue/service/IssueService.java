package com.ibm.issue.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.ibm.issue.dao.ReportMapper;
import com.ibm.issue.pojo.Report;

@Service
public class IssueService {
	@Autowired
	private ReportMapper reportMapper;
	

	public Report create(Report issue) {
	Date date = new Date(System.currentTimeMillis());
	issue.setCreatedate(date);
	Long currentTimeMillis = System.currentTimeMillis();
	String string = currentTimeMillis.toString();
	String issueid = string.substring(string.length()-6);
	issue.setIssueid(issueid);
	return null;
	}
}
