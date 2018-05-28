package com.publiccar.code.consumption.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.publiccar.code.consumption.dao.ConsumptionDaoInter;
import com.publiccar.code.model.Consumption;
import com.publiccar.code.model.PublicCar;

import framework.base.BaseDao;
import framework.util.PageUtil;


@Repository
public class ConsumptionDaoImpl extends BaseDao implements ConsumptionDaoInter {
	@Override
	public void selectconsumption(HttpServletRequest req, int currpage){
		String sql = "select * from consumption";
		PageUtil pageUtil = new PageUtil();
	    pageUtil.doPage(sql, this.getSession(), req, currpage);
	}
	@Override
	public List queryconsumption(Integer userid){
		Session session = this.getSession();
		List<PublicCar> carlist = new ArrayList<PublicCar>();
		String hql = "from PublicCar where driverId =  ?";
		Query query = session.createQuery(hql);
		query.setInteger(0, userid);
		carlist = query.list();
		return carlist;
	}
	@Override
	public void insertconsumption(Consumption consumption){
		Session session = this.getSession();
		session.save(consumption);
	}
	@Override
	public void deleteconsumption(Consumption consumption){
		Session session = this.getSession();
		session.delete(consumption);
	}
}
