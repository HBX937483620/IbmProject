package com.ibm.issue.service;

//import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.swing.plaf.synth.SynthScrollPaneUI;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ibm.issue.dao.ReportMapper;
import com.ibm.issue.dao.UserAndIdentityMapper;

import com.ibm.issue.dao.ReportMapper;
import com.ibm.issue.dao.UserMapper;
import com.ibm.issue.pojo.EmailMessage;
import com.ibm.issue.pojo.IssueReport;
import com.ibm.issue.pojo.Report;
import com.ibm.issue.pojo.ReportExample;
import com.ibm.issue.pojo.ReportWithBLOBs;
import com.ibm.issue.pojo.User;
import com.ibm.issue.pojo.UserExample;
import com.ibm.issue.pojo.ReportExample.Criteria;
import com.ibm.issue.pojo.ReportPage;

@Service
public class ReportService {
	@Autowired
	private ReportMapper reportMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserAndIdentityMapper mapper;

	@Value("${web.upload-path}")
	private static String fileRootPath;

	@Value("${spring.mail.username}")
	private String mailFrom;

	@Autowired
	private JavaMailSender sendEmail;

	/**
	 * 文件上传方法
	 * 
	 * @param files
	 * @return
	 */
	public static String file(MultipartFile[] files) {
		String filePath = "";
		String url = "";
		// 多文件上传
		System.out.println();
		for (MultipartFile file : files) {
			// 上传简单文件名
			String originalFilename = file.getOriginalFilename();
			// 存储路径
			long name = System.currentTimeMillis();
			filePath = new StringBuilder(fileRootPath).append(name + ".png").toString();
			System.out.println(filePath);
			url = url + name + ";";
			try {
				// 保存文件
				file.transferTo(new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String[] split = url.split(";");
		for (int i = 0; i < split.length; i++) {
			String string = split[i];
			System.out.println(string);
		}
		return url;
	}

	/**
	 * 创建人创建issue表
	 * 
	 * @param issue
	 * @return
	 * @throws MessagingException
	 */
	public Integer createReport(ReportWithBLOBs issue) throws MessagingException {

		Date date = new Date(System.currentTimeMillis());
		issue.setCreatedate(date);
		Long currentTimeMillis = System.currentTimeMillis();
		String string = currentTimeMillis.toString();
		String issueid = string.substring(string.length() - 6);
		issue.setIssueid(issueid);
		int insert = reportMapper.insert(issue);
		
		
		User user = new User();
		user.setUserid(issue.getModifier());

		// 查询指定修改者的邮箱
		UserExample userExample = new UserExample();
		com.ibm.issue.pojo.UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andUseridEqualTo(issue.getModifier());
		List<User> selectByExample = userMapper.selectByExample(userExample);

		// 查询出指定修改这的issue报表信息，用于发送邮件
		IssueReport issueReport = mapper.findIssueReportToSend(user);

		if (issueReport.getModifiNum() == 0) {
			issueReport.setCompleteRate(0.00);
			Double completeRate = (issueReport.getCompleteRate() * 100.00);
			issueReport.setRateString(completeRate.toString() + "%");
		} else {
			Double completeRate = (issueReport.getCompleteRate() * 100.00);
			issueReport.setRateString(completeRate.toString() + "%");
		}

		MimeMessage mimeMessage = sendEmail.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		// 邮件设置
		helper.setSubject("issue事务通知");
		helper.setText(EmailMessage.sendSession(issueReport, issue.getCreator()), true);
		helper.setTo(selectByExample.get(0).getEmail());
		helper.setFrom(mailFrom);
		sendEmail.send(mimeMessage);
		System.out.println(selectByExample.get(0).getEmail());
		
		return insert;

	}

	/**
	 * 创建人创建issue表
	 * 
	 * @param issue
	 * @return
	 */

//	public Integer createReport(ReportWithBLOBs issue) {
//		Date date = new Date(System.currentTimeMillis());
//		issue.setCreatedate(date);
//		Long currentTimeMillis = System.currentTimeMillis();
//		String string = currentTimeMillis.toString();
//		String issueid = string.substring(string.length() - 6);
//		issue.setIssueid(issueid);
//		if (issue.getFiles() != null) {
//			issue.setUrl(file(issue.getFiles()));
//		}
//		return reportMapper.insertSelective(issue);
//	}

	/**
	 * 点击详情查看issue報表
	 * 
	 * @param issue
	 * @return
	 */
	public List<ReportWithBLOBs> details(ReportWithBLOBs issue) {
		ReportExample reportExample = new ReportExample();
		Criteria createCriteria = reportExample.createCriteria();
		createCriteria.andIssueidEqualTo(issue.getIssueid());
		return reportMapper.selectByExampleWithBLOBs(reportExample);
	}

	/**
	 * 修改人填写解决方案
	 * 
	 * @param issue
	 * @return
	 */
	public int solve(ReportWithBLOBs issue) {
		ReportExample reportExample = new ReportExample();
		Criteria criteria = reportExample.createCriteria();
		criteria.andIssueidEqualTo(issue.getIssueid());
		ReportWithBLOBs report = new ReportWithBLOBs();
		report.setSolution(issue.getSolution());
		report.setState(2);
		return reportMapper.updateByExampleSelective(report, reportExample);
	}

	/**
	 * 创建人决定是否退回修改
	 * 
	 * @param issue
	 * @return
	 */
	public int verify(ReportWithBLOBs issue) {
		issue.getFlag();
		ReportExample reportExample = new ReportExample();
		Criteria criteria = reportExample.createCriteria();
		criteria.andIssueidEqualTo(issue.getIssueid());
		ReportWithBLOBs report = new ReportWithBLOBs();
		if (issue.getFlag().equals("1")) {
			report.setState(1);
		} else {
			Date date = new Date(System.currentTimeMillis());
			report.setEnddate(date);
			report.setState(3);
		}
		return reportMapper.updateByExampleSelective(report, reportExample);
	}

	public String selectLikeByReport(ReportPage reportPage) {
		// 使用插件分页查询
		System.out.println(reportPage.getPage());
		System.out.println(reportPage.getRows());
		PageHelper.startPage(reportPage.getPage(), reportPage.getRows());

		// 建立多表查询和模糊查询
		List<ReportPage> reportFind = mapper.findReportAndState(reportPage);

		// 转化为json
		String list = JSON.toJSONString(reportFind);
		PageInfo info = new PageInfo(reportFind);
		long total = info.getTotal();
		String json = "{\"total\":" + total + ",\"rows\":" + list + " }";
		return json;
	}

	/**
	 * 模糊查询用户issue的各种数据（创建数等）
	 * 
	 * @param user
	 * @return
	 */
	public String findIssueReport(User user) {
		List<IssueReport> findIssueReport = mapper.findIssueReport(user);
		for (IssueReport issueReport : findIssueReport) {
			if (issueReport.getModifiNum() == 0) {
				issueReport.setCompleteRate(0.00);
				Double completeRate = (issueReport.getCompleteRate() * 100.00);
				issueReport.setRateString(completeRate.toString() + "%");
			} else {
				Double completeRate = (issueReport.getCompleteRate() * 100.00);
				issueReport.setRateString(completeRate.toString() + "%");
			}
		}
		return JSON.toJSONString(findIssueReport);
	}

}