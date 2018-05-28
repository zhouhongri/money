package com.publiccar.code.car.service;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.PublicCar;

public interface CarServiceInter {
	public String queryCarService(HttpServletRequest req, String currpage);
	public PublicCar queryCarByIdService(PublicCar publicCar);
}
