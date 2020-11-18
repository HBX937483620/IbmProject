package com.ibm.issue.dao;

import java.util.List;

import com.ibm.issue.pojo.User;

public interface UserAndIdentityMapper {
	List<User> findUserAndIdentity();
}
