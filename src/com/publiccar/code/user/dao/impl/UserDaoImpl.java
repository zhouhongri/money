package com.publiccar.code.user.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.publiccar.code.model.User;
import com.publiccar.code.user.dao.UserDaoInter;

import framework.base.BaseDao;

@Repository
public class UserDaoImpl extends BaseDao implements UserDaoInter{

	@Override
	public User getUserByIdDao(User user) {
		Session session = this.getSession();
		User userInstance = (User) session.get(user.getClass(), user.getUserId());
		return userInstance;
	}
	
}
