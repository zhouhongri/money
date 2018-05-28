package com.publiccar.code.car.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publiccar.code.car.dao.CarDaoInter;
import com.publiccar.code.car.service.CarServiceInter;
import com.publiccar.code.model.PublicCar;

@Service
public class CarServiceImpl implements CarServiceInter{
	
	@Autowired
	public CarDaoInter carDaoInter;
	@Override
	public void queryCarService(HttpServletRequest req, String currpage) {
		int intcurrpage = Integer.parseInt(currpage);
		this.carDaoInter.queryCars(req, intcurrpage);
	}
	@Override
	public PublicCar queryCarByIdService(PublicCar publicCar) {
		PublicCar car = this.carDaoInter.qyeryCarById(publicCar);
		return car;
	}
	
}
