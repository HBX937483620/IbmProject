package com.ibm.issue.controller;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.ibm.issue.pojo.ReportWithBLOBs;
import com.ibm.issue.service.ReportService;

 

@RestController
public class ReportController {
	@Autowired
	private ReportService reportService;
	
	

	@PostMapping("file")
	public String file(@RequestBody MultipartFile[] files ) {
		return reportService.file(files);
	}
	
	/**
	 * 创建issue表接口
	 * @param issue
	 * @return
	 * @throws MessagingException 
	 */
	@PostMapping("createReport")
	public Integer create(@RequestBody ReportWithBLOBs issue) throws MessagingException {
		return reportService.createReport(issue);	
	}
	
	/**
	 * 查看issue報表详情接口
	 * @param issue
	 * @return
	 */
	@PostMapping("reportDetails")
	public String reportDetails(@RequestBody ReportWithBLOBs issue) {
		return JSON.toJSONString(reportService.details(issue));
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
