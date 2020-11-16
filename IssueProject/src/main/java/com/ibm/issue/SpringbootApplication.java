package com.ibm.issue;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAsync //开启异步注解功能
//@EnableScheduling //开启基于注解的定时任务
//@MapperScan(value = "com.ibm.issue.dao")
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
