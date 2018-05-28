package com.publiccar.code.login.dao;

import java.util.List;

import com.publiccar.code.model.User;

public interface LoginDaoInter {
	public List<User> getUserByName(String username);
}
