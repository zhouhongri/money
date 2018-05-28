package com.publiccar.code.dispatch.dao.impl;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.publiccar.code.dispatch.dao.DispatchDaoInter;
import com.publiccar.code.model.Dispatch;

import framework.base.BaseDao;
import framework.util.PageUtil;

@Repository
public class DispatchDaoImpl extends BaseDao implements DispatchDaoInter{

	@Override
	public void insertDispatchDao(Dispatch dispatch) {
		Session session = this.getSession();
		session.save(dispatch);
	}

	@Override
	public void queryDispatchDao(HttpServletRequest req, int currpage) {
		String sql = "select * from dispatch";
		PageUtil pageUtil = new PageUtil();
	    pageUtil.doPage(sql, this.getSession(), req, currpage);
	}

}
