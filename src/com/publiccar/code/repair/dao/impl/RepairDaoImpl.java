package com.publiccar.code.repair.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.publiccar.code.model.Annual;
import com.publiccar.code.model.Dispatch;
import com.publiccar.code.model.PublicCar;
import com.publiccar.code.model.Repair;
import com.publiccar.code.repair.dao.RepairDaoInter;

import framework.base.BaseDao;
import framework.util.PageUtil;

@Repository
public class RepairDaoImpl extends BaseDao implements RepairDaoInter {
	
	@Override
	public void selectrepair(HttpServletRequest req, int currpage) {
		String sql = "select * from repair ";
		PageUtil pageUtil = new PageUtil();
	    pageUtil.doPage(sql, this.getSession(), req, currpage);
	}

	@Override
	public List queryrapair(Integer userid) {
		Session session = this.getSession();
		List<PublicCar> carlist = new ArrayList<PublicCar>();
		String hql = "from PublicCar where driverId =  ?";
		Query query = session.createQuery(hql);
		query.setInteger(0, userid);
		carlist = query.list();
		return carlist;
	}
	
	@Override
	public void insertrapair(Repair repair) {
		Session session = this.getSession();
		session.save(repair);
	}
	
	@Override
	public void deleterapair(Repair repair) {
		Session session = this.getSession();
		session.delete(repair);
	}
	@Override
	public void queryrapairid(Repair repair,HttpServletRequest req, int currpage){
		Integer repairId = repair.getRepairId();
		Session session = this.getSession();
		List<PublicCar> conlist = new ArrayList<PublicCar>();
		String sql = "select * from repair where repair_id =  "+"'"+repairId+"'";
		PageUtil pageUtil = new PageUtil();
	    pageUtil.doPage(sql, this.getSession(), req, currpage);
	}


}
