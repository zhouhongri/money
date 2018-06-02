package com.publiccar.code.user.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.User;

public interface UserDaoInter {
	public User getUserByIdDao(User user);
	public void insertUserDao(User user);
	public int delUserDao(User user);
	public void updateUserDao(User user);
	public void queryUserDao(HttpServletRequest req,int currpage);
	public List checkUsernameDao(User user);
}
