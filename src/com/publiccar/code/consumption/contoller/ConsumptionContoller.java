package com.publiccar.code.consumption.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.publiccar.code.consumption.service.ConsumptionServiceInter;
import com.publiccar.code.model.Consumption;
import com.publiccar.code.model.PublicCar;
import com.publiccar.code.model.Repair;

//油耗管理
@Controller
@RequestMapping("consumption")
public class ConsumptionContoller {
	@Autowired
	private ConsumptionServiceInter consumptionSercice;
	//查询油耗信息
	@RequestMapping("/selectconsumption")
	 public String selectconsumption(HttpServletRequest req, String currpage) {
	       this.consumptionSercice.selectconsumption(req, currpage);
	       return "driver/consumptionlist";
	}
	//跳转新增页面
		@RequestMapping("/queryconsumption")
			public String queryconsumption(HttpServletRequest req) {
			PublicCar car = this.consumptionSercice.queryconsumption(req);
			req.setAttribute("PublicCar", car);
				return "driver/consumption_add";
			}
		//添加油耗信息
			@RequestMapping("/insertconsumption")
			public String insertconsumption(HttpServletRequest req,Consumption consumption) {
				this.consumptionSercice.insertconsumption(req, consumption);
				return "driver/consumption_add";
			}
		//删除油耗信息
			@RequestMapping("/deleteconsumption")
			public String deleteconsumption(HttpServletRequest req,Consumption consumption) {
		        this.consumptionSercice.deleteconsumption(req, consumption);
				return "redirect:/consumption/selectconsumption?currpage=1";
			}		

}