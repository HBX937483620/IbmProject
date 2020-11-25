package com.ibm.issue.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.ibm.issue.dao.UserAndIdentityMapper;
import com.ibm.issue.dao.UserMapper;
import com.ibm.issue.pojo.AllMessage;
import com.ibm.issue.pojo.User;
import com.ibm.issue.pojo.UserExample;
import com.ibm.issue.pojo.UserExample.Criteria;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserAndIdentityMapper mapper;

	@Value("${web.user-path}")
	private String fileRootPath;

	/**
	 * 用于返回但钱用户的修改issue数和完成数
	 * @return
	 */
	public String getUser(User user) {
		return JSON.toJSONString(mapper.findIssueReportToSend2(user));
	}

	/**
	 * 用于测试是否成功返回数据
	 * 
	 * @return
	 */
	public String getAll() {
		AllMessage findIssueAll = mapper.findIssueAll();
		AllMessage findUserAll = mapper.findUserAll();
		findIssueAll.setCommonNum(findUserAll.getCommonNum());
		findIssueAll.setManageNum(findUserAll.getManageNum());
		findIssueAll.setAdminNum(findUserAll.getAdminNum());
		return JSON.toJSONString(findIssueAll);
	}

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @return
	 */
	public Integer updateUser(User user) {
		UserExample userExample = new UserExample();
		Criteria updateUser = userExample.createCriteria();
		updateUser.andUseridEqualTo(user.getUserid());
		

		// 查询原用户信息
		List<User> userFind = userMapper.selectByExample(userExample);
		User userGet = userFind.get(0);
		// 修改
		if (user.getName() != null) {
			userGet.setName(user.getName());
		}
		if (user.getEmail() != null) {
			userGet.setEmail(user.getEmail());
		}
		if (user.getPassword() != null) {
			userGet.setPassword(user.getPassword());
		}

		// 执行修改语句保存到数据库
		int isUpdate = userMapper.updateByExampleSelective(user, userExample);
		return isUpdate;
	}

	/**
	 * 返回修改完后的信息
	 */
	public User getUpdateUser(User user) {
		UserExample userExample = new UserExample();
		Criteria updateUser = userExample.createCriteria();
		updateUser.andUseridEqualTo(user.getUserid());
		return userMapper.selectByExample(userExample).get(0);
	}

	/**
	 * 头像
	 */
	public String getUserPic(String userid,MultipartFile file) {
		String filePath = "";
		String url = "";
		System.out.println(fileRootPath);
		//获取文件元名称
//		String originalFilename = file.getOriginalFilename();
		// 存储路径
		long name = System.currentTimeMillis();
		filePath = new StringBuilder(fileRootPath).append(name + ".png").toString();
		
		url = name + "";
		try {
			// 保存文件
			file.transferTo(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//把用户头像保存到数据库
		UserExample example = new UserExample();
		Criteria create = example.createCriteria();
		create.andUseridEqualTo(userid);
		User user = new User();
		user.setUrl(url);
		userMapper.updateByExampleSelective(user, example);

		return url;
	}

}
