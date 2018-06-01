package com.publiccar.code.car.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publiccar.code.car.dao.CarDaoInter;
import com.publiccar.code.car.service.CarServiceInter;
import com.publiccar.code.model.PublicCar;
import com.publiccar.code.model.User;

@Service
public class CarServiceImpl implements CarServiceInter{
	
	@Autowired
	public CarDaoInter carDaoInter;
	@Override
	public String queryCarService(HttpServletRequest req, String currpage) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		int intcurrpage = Integer.parseInt(currpage);
		String dempName = user.getUserDemp();
		if("车辆部门".equals(dempName)) {
			this.carDaoInter.queryCars(req, intcurrpage);
			return "车辆部门";
		}else if("管理员".equals(dempName)) {
			this.carDaoInter.queryCars(req, intcurrpage);
			return "管理员";
		}else {
			this.carDaoInter.queryCars(req, intcurrpage, dempName);
			return "用车官员";
		}
	}
	@Override
	public PublicCar queryCarByIdService(PublicCar publicCar) {
		PublicCar car = this.carDaoInter.qyeryCarById(publicCar);
		return car;
	}
	@Override
	public String delCarByIdService(PublicCar publicCar) {
		int num = this.carDaoInter.delCarByIdDao(publicCar);
		if(num==1) {
			return "success";
		}else {
			return "flase";
		}
	}
	
}
