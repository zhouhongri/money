package com.publiccar.code.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publiccar.code.model.User;
import com.publiccar.code.user.dao.UserDaoInter;
import com.publiccar.code.user.service.UserServiceInter;

@Service
public class UserServiceImpl implements UserServiceInter{
	
	@Autowired
	public UserDaoInter userDaoInter;
	
	@Override
	public User getUserByIdService(User user) {
		User userInstance = this.userDaoInter.getUserByIdDao(user);
		return userInstance;
	}
	
}
