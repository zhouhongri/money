package com.publiccar.code.car.dao.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.publiccar.code.car.dao.CarDaoInter;
import com.publiccar.code.model.PublicCar;

import framework.base.BaseDao;
import framework.util.PageUtil;

@Repository
public class CarDaoImpl extends BaseDao implements CarDaoInter{

	@Override
	public void queryCars(HttpServletRequest req, int currpage, String dempName) {
		String sql = "select * from public_car where car_status=0 and car_insurance_status=0"
				+ " and car_annual_status=0 and demp_name='"+dempName+"'";
		PageUtil pageUtil = new PageUtil();
	    pageUtil.doPage(sql, this.getSession(), req, currpage);
	}

	@Override
	public PublicCar qyeryCarById(PublicCar publicCar) {
		Session session = this.getSession();
		PublicCar car = (PublicCar) session.get(publicCar.getClass(), publicCar.getCarId());
		return car;
	}

	@Override
	public void queryCars(HttpServletRequest req, int currpage) {
		String sql = "select * from public_car";
		PageUtil pageUtil = new PageUtil();
	    pageUtil.doPage(sql, this.getSession(), req, currpage);
	}

	@Override
	public int delCarByIdDao(PublicCar publicCar) {
		Session session = this.getSession();
		String hql = "delete from PublicCar where carId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, publicCar.getCarId());
		return query.executeUpdate();
	}

	@Override
	public int updateStatusById(String status, Integer publicCarId) {
		Session session = this.getSession();
		String hql = "update PublicCar set carStatus='"+status+"' where carId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, publicCarId);
		return query.executeUpdate();
	}

	@Override
	public void updateCarDao(PublicCar publicCar) {
		Session session = this.getSession();
		session.update(publicCar);
	}

	@Override
	public void insertCarDao(PublicCar publicCar) {
		Session session = this.getSession();
		session.save(publicCar);
	}

	@Override
	public List queryOtherDriverNameDao() {
		Session session = this.getSession();
		String sql = "select user.user_id,user_name from user left JOIN public_car on user.user_id=public_car.driver_id where driver_id is null and user_identity='1'";
		Query query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}

	@Override
	public void queryDempNameCarDao(HttpServletRequest req, int currpage) {
		String sql = "select * from public_car where demp_name=null or demp_name=''";
		PageUtil pageUtil = new PageUtil();
	    pageUtil.doPage(sql, this.getSession(), req, currpage);
	}
	
}
