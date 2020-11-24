package com.ibm.issue.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.ibm.issue.pojo.ReportWithBLOBs;
import com.ibm.issue.service.ReportService;

 

@RestController
public class ReportController {
	@Autowired
	private ReportService reportService;

	/**
	 * 创建issue表接口
	 * @param issue
	 * @return
	 * @throws MessagingException 
	 */
	@PostMapping("createReport")
	public Integer create(@RequestBody ReportWithBLOBs issue ) throws MessagingException {
		return reportService.createReport(issue);	
	}
	
	/**
	 * 查看issue報表详情接口
	 * @param issue
	 * @return
	 */
	@PostMapping("reportDetails")
	public List<ReportWithBLOBs> reportDetails(@RequestBody ReportWithBLOBs issue) {
		return reportService.details(issue);
	}
	
/**
 * 修改者填写解决方案
 * @param issue
 * @return
 */
	@PostMapping("solve")
	public int solution(@RequestBody ReportWithBLOBs issue) {
		return reportService.solve(issue);
	}
	
/**
 * 退回修改或者关闭
 * @param issue
 * @return
 */
	@PostMapping("verify")
	public int verification(@RequestBody ReportWithBLOBs issue) {
		System.out.println(111);
		return reportService.verify(issue);
	}
	
	

}
