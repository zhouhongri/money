package com.publiccar.code.insurance.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.publiccar.code.insurance.dao.InsuranceDaoInter;
import com.publiccar.code.model.Insurance;
import com.publiccar.code.model.Peccancy;
import com.publiccar.code.model.PublicCar;

import framework.base.BaseDao;
import framework.util.PageUtil;

@Repository
public class InsuranceDaoImpl extends BaseDao implements InsuranceDaoInter {
	@Override
	public void selectinsurance(HttpServletRequest req, int currpage){
		String sql = "select * from insurance";
		PageUtil pageUtil = new PageUtil();
	    pageUtil.doPage(sql, this.getSession(), req, currpage);
	}
	@Override
	public List queryinsurance(Integer userid){
		Session session = this.getSession();
		List<PublicCar> carlist = new ArrayList<PublicCar>();
		String hql = "from PublicCar where driverId =  ?";
		Query query = session.createQuery(hql);
		query.setInteger(0, userid);
		carlist = query.list();
		return carlist;
	}
	@Override
	public void insertinsurance(Insurance insurance){
		Session session = this.getSession();
		session.save(insurance);
	}
	@Override
	public void deleteinsurance(Insurance insurance){
		Session session = this.getSession();
		session.delete(insurance);
	}
	
	@Override
	public int updatepubliccardate(Integer carId,String insuranceEnddate) {
		Session session = this.getSession();
		String hql = "update PublicCar set carInsuranceEndtime='"+insuranceEnddate+"' where carId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, carId);
		return query.executeUpdate();
	}
	@Override
	public void queryinsuranceid(Insurance insurance,HttpServletRequest req, int currpage){
		Integer insuranceId = insurance.getInsuranceId();
		Session session = this.getSession();
		List<PublicCar> conlist = new ArrayList<PublicCar>();
		String sql = "select * from insurance where insurance_id =  "+"'"+insuranceId+"'";
		PageUtil pageUtil = new PageUtil();
	    pageUtil.doPage(sql, this.getSession(), req, currpage);
	}

}
