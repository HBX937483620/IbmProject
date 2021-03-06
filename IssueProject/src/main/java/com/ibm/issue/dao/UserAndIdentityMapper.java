package com.ibm.issue.dao;

import java.util.List;

import com.ibm.issue.pojo.AllMessage;
import com.ibm.issue.pojo.IssueReport;
import com.ibm.issue.pojo.ReportPage;
import com.ibm.issue.pojo.ReportWithBLOBs;
import com.ibm.issue.pojo.User;
import com.ibm.issue.pojo.UserPage;

public interface UserAndIdentityMapper {
	List<User> test(User user);
	
	List<User> findUserAndIdentity(UserPage user);
	
	List<ReportPage> findReportAndState(ReportPage r);
	
	List<ReportWithBLOBs> findReportAndState2(ReportWithBLOBs r);
	
	List<IssueReport> findIssueReport(User user);
	
	IssueReport findIssueReportToSend(User user);
	IssueReport findIssueReportToSend2(User user);
	
	AllMessage findUserAll();
	
	AllMessage findIssueAll();

}
