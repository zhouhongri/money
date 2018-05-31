package com.publiccar.code.annual.dao.impl;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.publiccar.code.annual.dao.AnnualDaoInter;
import com.publiccar.code.model.Annual;
import com.publiccar.code.model.Consumption;
import com.publiccar.code.model.PublicCar;

import framework.base.BaseDao;
import framework.util.PageUtil;
@Repository
public class AnnualDaoImpl extends BaseDao implements AnnualDaoInter{

	@Override
	public void selectannual(HttpServletRequest req, int currpage){
		String sql = "select * from annual";
		PageUtil pageUtil = new PageUtil();
	    pageUtil.doPage(sql, this.getSession(), req, currpage);
	}
	@Override
	public List queryannual(Integer userid){
		Session session = this.getSession();
		List<PublicCar> carlist = new ArrayList<PublicCar>();
		String hql = "from PublicCar where driverId =  ?";
		Query query = session.createQuery(hql);
		query.setInteger(0, userid);
		carlist = query.list();
		return carlist;
	}
	@Override
	public void insertannual( Annual annual){
		Session session = this.getSession();
		session.save(annual);
	}
	@Override
	public void deleteannual(Annual annual){
		Session session = this.getSession();
		session.delete(annual);
	}
}
