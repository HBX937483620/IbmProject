package com.ibm.issue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
	@GetMapping("/test")
	public String Test() {
		return "hello";
	}
}
