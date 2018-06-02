package com.publiccar.code.car.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.PublicCar;
import com.publiccar.code.model.User;

public interface CarServiceInter {
	public String queryCarService(HttpServletRequest req, String currpage);
	public PublicCar queryCarByIdService(PublicCar publicCar);
	public String delCarByIdService(PublicCar publicCar);
	public String updateStatusById(String status, Integer publicCarId);
	public void updateCarService(PublicCar publicCar);
	public void insertCarService(PublicCar publicCar, User user);
	public List queryOtherDriverNameSerive();
}
