package com.publiccar.code.car.dao;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.PublicCar;

public interface CarDaoInter {
	public void queryCars(HttpServletRequest req, int currpage);
	public PublicCar qyeryCarById(PublicCar publicCar);
}
