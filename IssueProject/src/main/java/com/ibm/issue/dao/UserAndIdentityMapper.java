package com.ibm.issue.dao;

import java.util.List;

import com.ibm.issue.pojo.ReportPage;
import com.ibm.issue.pojo.ReportWithBLOBs;
import com.ibm.issue.pojo.User;
import com.ibm.issue.pojo.UserPage;

public interface UserAndIdentityMapper {
	List<User> test(User user);
	
	List<User> findUserAndIdentity(UserPage user);
	
	
	List<ReportPage> findReportAndState(ReportPage r);
}
