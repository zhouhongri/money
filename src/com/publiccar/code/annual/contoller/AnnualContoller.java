package com.publiccar.code.annual.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.publiccar.code.annual.service.AnnualServiceInter;
import com.publiccar.code.consumption.service.ConsumptionServiceInter;
import com.publiccar.code.model.Annual;
import com.publiccar.code.model.Consumption;
import com.publiccar.code.model.PublicCar;

   //年检管理
	@Controller
	@RequestMapping("annual")
    public class AnnualContoller {
		@Autowired
		private  AnnualServiceInter annualservice;
		//查询年检列表
		@RequestMapping("/selectannual")
		 public String selectannual(HttpServletRequest req, String currpage) {
		       this.annualservice.selectannual(req, currpage);
		       return "driver/annuallist";
		}
		//跳转年检新增页面
			@RequestMapping("/queryannual")
				public String queryannual(HttpServletRequest req) {
				PublicCar car = this.annualservice.queryannual(req);
				req.setAttribute("PublicCar", car);
					return "driver/annual_add";
				}
			//年检新增、改变车辆表年检到期时间
				@RequestMapping("/insertannual")
				public String insertannual(HttpServletRequest req,Annual annual ) {
					this.annualservice.insertannual(req, annual);
					return "driver/annual_add";
				}
			//删除年检
				@RequestMapping("/deleteannual")
				public String deleteannual(HttpServletRequest req,Annual annual) {
			        this.annualservice.deleteannual(req, annual);
					return "redirect:/annual/selectannual?currpage=1";
				}		
				
				//年检编号查询
				@RequestMapping("/queryannualid")
				public String queryannualid(HttpServletRequest req,Annual annual) {
					this.annualservice.queryannualid(req, annual);
					return "driver/annuallist";
				}		
	}

	

