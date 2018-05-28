package com.publiccar.code.login.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.publiccar.code.model.User;

public interface LoginServiceInter {
	public Map<String,Object> login(HttpSession session,User user);
}
