package com.publiccar.code.car.dao.impl;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.publiccar.code.car.dao.CarDaoInter;
import com.publiccar.code.model.PublicCar;

import framework.base.BaseDao;
import framework.util.PageUtil;

@Repository
public class CarDaoImpl extends BaseDao implements CarDaoInter{

	@Override
	public void queryCars(HttpServletRequest req, int currpage) {
		String sql = "select * from public_car where car_status=0 and car_insurance_status=0"
				+ " and car_annual_status=0";
		PageUtil pageUtil = new PageUtil();
	    pageUtil.doPage(sql, this.getSession(), req, currpage);
	}

	@Override
	public PublicCar qyeryCarById(PublicCar publicCar) {
		Session session = this.getSession();
		PublicCar car = (PublicCar) session.get(publicCar.getClass(), publicCar.getCarId());
		return car;
	}
	
}
