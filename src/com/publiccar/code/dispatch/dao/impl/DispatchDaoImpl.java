package com.publiccar.code.dispatch.dao.impl;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.publiccar.code.dispatch.dao.DispatchDaoInter;
import com.publiccar.code.model.Dispatch;
import com.publiccar.code.model.User;

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
		String sql;
		User user = (User) req.getSession().getAttribute("user");
		String dempname = user.getUserDemp();
		if(dempname==null||"".equals(dempname)) {
			sql = "select * from dispatch where driver_id='"+user.getUserId()+"' and dispatch_status='1'";
		}else {
			sql = "select * from dispatch";
		}
		PageUtil pageUtil = new PageUtil();
	    pageUtil.doPage(sql, this.getSession(), req, currpage);
	}

	@Override
	public int updateDispatchDao(String dispatchStatus, Integer dispatchId) {
		Session session = this.getSession();
		String hql = "update Dispatch set dispatchStatus='"+dispatchStatus+"' where dispatchId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, dispatchId);
		return query.executeUpdate();
	}

}
