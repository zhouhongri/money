package com.publiccar.code.login.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.publiccar.code.login.dao.LoginDaoInter;
import com.publiccar.code.model.User;

import framework.base.BaseDao;

@Repository
public class LoginDaoImpl extends BaseDao implements LoginDaoInter{
	
	public List<User> getUserByName(String getUserUsername) {
		Session session = this.getSession();
		String hql="from User where userUsername=?";
		Query query = session.createQuery(hql);
		query.setString(0,getUserUsername);
		List<User> userList = query.list();
		return userList;
	}
	
}
