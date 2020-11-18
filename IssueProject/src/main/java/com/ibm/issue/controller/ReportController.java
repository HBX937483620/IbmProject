package com.ibm.issue.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.issue.pojo.Report;
import com.ibm.issue.pojo.ReportWithBLOBs;
import com.ibm.issue.service.ReportService;

 

@RestController
public class ReportController {
	@Autowired
	private ReportService reportService;
	
	@PostMapping("createReport")
	public Integer create(@RequestBody ReportWithBLOBs issue ) {
		return reportService.createReport(issue);	
	}
	
	
	

	
}
