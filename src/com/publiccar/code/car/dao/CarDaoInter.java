package com.publiccar.code.car.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.PublicCar;

public interface CarDaoInter {
	public void queryCars(HttpServletRequest req, int currpage, String dempName);
	public void queryCars(HttpServletRequest req, int currpage);
	public PublicCar qyeryCarById(PublicCar publicCar);
	public int delCarByIdDao(PublicCar publicCar);
	public int updateStatusById(String status, Integer publicCarId);
	public void updateCarDao(PublicCar publicCar);
	public void insertCarDao(PublicCar publicCar);
	public List queryOtherDriverNameDao();
}
