package com.publiccar.code.car.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.publiccar.code.car.service.CarServiceInter;
import com.publiccar.code.model.PublicCar;

@Controller
@RequestMapping("carCtrl")
public class CarController {
	
	@Autowired
	public CarServiceInter carServiceInter;
	
	//��ѯ���з���Ҫ��ĳ�����Ϣ
	@RequestMapping("/queryCar")
	public String queryCarCtrl(HttpServletRequest req, String currpage) {
		this.carServiceInter.queryCarService(req, currpage);
		return "officials/cars";
	}
	//�ύ�ó�����
	@RequestMapping("/queryCarById")
	public String queryCarByIdCtrl(HttpServletRequest req, PublicCar publicCar) {
		PublicCar car = this.carServiceInter.queryCarByIdService(publicCar);
		req.setAttribute("PublicCar", car);
		return "officials/cars_update";
	}
}
