package com.ibm.issue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAsync //开启异步注解功能
//@EnableScheduling //开启基于注解的定时任务
@MapperScan(value = "com.ibm.issue.dao")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
