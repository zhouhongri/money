package com.publiccar.code.peccancy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.publiccar.code.model.Peccancy;
import com.publiccar.code.model.PublicCar;
import com.publiccar.code.model.Repair;
import com.publiccar.code.peccancy.dao.PeccancyDaoInter;

import framework.base.BaseDao;
import framework.util.PageUtil;

@Repository
public class PeccancyDaoImpl extends BaseDao implements PeccancyDaoInter {
	@Override
	public void selectpeccancy(HttpServletRequest req, int currpage){
		String sql = "select * from peccancy";
		PageUtil pageUtil = new PageUtil();
	    pageUtil.doPage(sql, this.getSession(), req, currpage);
	}
	@Override
	public List querypeccancy(Integer userid){
		Session session = this.getSession();
		List<PublicCar> carlist = new ArrayList<PublicCar>();
		String hql = "from PublicCar where driverId =  ?";
		Query query = session.createQuery(hql);
		query.setInteger(0, userid);
		carlist = query.list();
		return carlist;
	}
	@Override
	public void insertpeccancy(Peccancy peccancy){
		Session session = this.getSession();
		session.save(peccancy);
	}
	@Override
	public void deletepeccancy(Peccancy peccancy){
		Session session = this.getSession();
		session.delete(peccancy);
	}
	
	@Override
	public void querypeccancyid(Peccancy peccancy,HttpServletRequest req, int currpage){
		Integer peccancyId = peccancy.getPeccancyId();
		Session session = this.getSession();
		List<PublicCar> conlist = new ArrayList<PublicCar>();
		String sql = "select * from peccancy where peccancy_id =  "+"'"+peccancyId+"'";
		PageUtil pageUtil = new PageUtil();
	    pageUtil.doPage(sql, this.getSession(), req, currpage);
	}

}
