package com.publiccar.code.dispatch.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publiccar.code.dispatch.dao.DispatchDaoInter;
import com.publiccar.code.dispatch.service.DispatchServiceInter;
import com.publiccar.code.model.Dispatch;
import com.publiccar.code.model.User;

@Service
public class DispatchServiceImpl implements DispatchServiceInter{
	
	@Autowired
	public DispatchDaoInter dispatchDaoInter;

	@Override
	public void insertDispatchService(HttpServletRequest req, Dispatch dispatch) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		dispatch.setDempId(user.getDempId());
		dispatch.setDispatchStatus("0");
		this.dispatchDaoInter.insertDispatchDao(dispatch);
	}

	@Override
	public void queryDispatchService(HttpServletRequest req, String currpage) {
		int intcurrpage = Integer.parseInt(currpage);
		this.dispatchDaoInter.queryDispatchDao(req, intcurrpage);
	}
	
}
