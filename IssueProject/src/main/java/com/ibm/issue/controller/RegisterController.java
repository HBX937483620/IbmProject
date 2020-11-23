package com.ibm.issue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.issue.pojo.EmailMessage;
import com.ibm.issue.pojo.User;
import com.ibm.issue.service.RegisterService;

@RestController
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@PostMapping("sendEmail")
	public String sendEmail(@RequestBody EmailMessage emailTo) {
		return registerService.sendEmail(emailTo.getMailTo());
	}
	
	
	@PostMapping("register")
	public Integer register(@RequestBody User user) {
		return registerService.register(user);
	}
	
	@PostMapping("isExistId")
	public Boolean isExistId(@RequestBody User user) {
		return !registerService.isExistId(user);
	}
	
	@PostMapping("login")
	public String login(@RequestBody User user) {
		return registerService.login(user);
	}
}
