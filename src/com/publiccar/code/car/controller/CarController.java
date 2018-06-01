package com.publiccar.code.car.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.publiccar.code.car.service.CarServiceInter;
import com.publiccar.code.model.PublicCar;
import com.publiccar.code.model.User;

@Controller
@RequestMapping("carCtrl")
public class CarController {
	
	@Autowired
	public CarServiceInter carServiceInter;
	
	//查询空闲符合要求的车辆信息
	@RequestMapping("/queryCar")
	public String queryCarCtrl(HttpServletRequest req, String currpage) {
		String flag = this.carServiceInter.queryCarService(req, currpage);
		if("车辆部门".equals(flag)) {
			return "cardemp/cars";
		}else if("管理员".equals(flag)){
			return "admin/cars";
		}else{
			return "officials/cars";
		}
	}
	//提交用车申请、更新车辆信息
	@RequestMapping("/queryCarById")
	public String queryCarByIdCtrl(HttpServletRequest req, PublicCar publicCar) {
		PublicCar car = this.carServiceInter.queryCarByIdService(publicCar);
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		req.setAttribute("PublicCar", car);
		if("管理员".equals(user.getUserDemp())) {
			return "admin/cars_update";
		}else {
			return "officials/cars_update";
		}
	}
	//提交用车申请
	@RequestMapping("/delCarById")
	@ResponseBody
	public String delCarByIdCtrl(PublicCar publicCar) {
		String flag = this.carServiceInter.delCarByIdService(publicCar);
		return flag;
	}
}
