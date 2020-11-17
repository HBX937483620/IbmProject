package com.ibm.issue.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.issue.pojo.Report;
import com.ibm.issue.service.IssueService;
 

@RestController
public class IssueController {
	@Autowired
	private IssueService issueService;
	
	@PostMapping("createIsseu")
	public Report create(@RequestBody Report issue) {
		return null;	
	}
	

	
}
