package com.publiccar.code.dispatch.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.publiccar.code.dispatch.dao.DispatchDaoInter;
import com.publiccar.code.model.Dispatch;
import com.publiccar.code.model.PublicCar;
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
		User user = (User) req.getSession().getAttribute("user");
		String userIdentity = user.getUserIdentity();
		String sql = "select * from dispatch where 1=1 ";
		if("3".equals(userIdentity)) {
			sql += " and user_id='"+user.getUserId()+"'";
		}
		if("1".equals(userIdentity)) {
			sql += " and driver_id='"+user.getUserId()+"' and dispatch_status in('1','3')";
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
	//查询车辆信息
	@Override
	public List querycar(Integer userid){
		Session session = this.getSession();
		List<PublicCar> carlist = new ArrayList<PublicCar>();
		String hql = "from PublicCar where driverId =  ?";
		Query query = session.createQuery(hql);
		query.setInteger(0, userid);
		carlist = query.list();
		return carlist;
	}

}
