package com.publiccar.code.car.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publiccar.code.car.dao.CarDaoInter;
import com.publiccar.code.car.service.CarServiceInter;
import com.publiccar.code.model.PublicCar;
import com.publiccar.code.model.User;
import com.publiccar.code.user.dao.UserDaoInter;

@Service
public class CarServiceImpl implements CarServiceInter{
	
	@Autowired
	public CarDaoInter carDaoInter;
	@Autowired
	public UserDaoInter userDaoInter;
	
	@Override
	public String queryCarService(HttpServletRequest req, String currpage) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		int intcurrpage = Integer.parseInt(currpage);
		String userIdentity = user.getUserIdentity();
		if("2".equals(userIdentity)) {
			this.carDaoInter.queryCars(req, intcurrpage);
			return "车辆部门";
		}else if("0".equals(userIdentity)) {
			this.carDaoInter.queryCars(req, intcurrpage);
			return "管理员";
		}else {
			this.carDaoInter.queryCars(req, intcurrpage, user.getUserDemp());
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
	@Override
	public String updateStatusById(String status, Integer publicCarId) {
		int num = this.carDaoInter.updateStatusById(status, publicCarId);
		if(num==1) {
			return "success";
		}else {
			return "false";
		}
	}
	@Override
	public void updateCarService(PublicCar publicCar) {
		this.carDaoInter.updateCarDao(publicCar);
	}
	@Override
	public void insertCarService(PublicCar publicCar, User user) {
		User userInstance = this.userDaoInter.getUserByIdDao(user);
		publicCar.setDriverId(userInstance.getUserId());
		publicCar.setDriverName(userInstance.getUserName());
		publicCar.setDriverSex(userInstance.getUserSex());
		publicCar.setDriverAge(userInstance.getUserAge());
		publicCar.setCarAnnualStatus("1");
		publicCar.setCarAnnualEndtime("");
		publicCar.setCarInsuranceStatus("1");
		publicCar.setCarInsuranceEndtime("");
		publicCar.setCarStatus("0");
		publicCar.setDempName("");
		this.carDaoInter.insertCarDao(publicCar);
	}
	@Override
	public List queryOtherDriverNameSerive() {
		List list = this.carDaoInter.queryOtherDriverNameDao();
		return list;
	}
	
}
