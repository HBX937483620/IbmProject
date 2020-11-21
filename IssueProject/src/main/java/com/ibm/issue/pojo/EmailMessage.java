package com.ibm.issue.pojo;

import org.springframework.beans.factory.annotation.Value;

public class EmailMessage {
	
    @Value("${spring.mail.username}")
    private String mailFrom;
    
    private String mailTo;

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
    
}
