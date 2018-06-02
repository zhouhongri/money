package com.publiccar.code.peccancy.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.publiccar.code.peccancy.service.PeccancyServiceInter;
import com.publiccar.code.model.Peccancy;
import com.publiccar.code.model.PublicCar;
import com.publiccar.code.model.Repair;


	//违章管理
	@Controller
	@RequestMapping("peccancy")
	public class PeccancyContoller {
		@Autowired
		private PeccancyServiceInter peccancySercice;
		//查询违章信息
		@RequestMapping("/selectpeccancy")
		 public String selectpeccancy(HttpServletRequest req, String currpage) {
		       this.peccancySercice.selectpeccancy(req, currpage);
		       return "driver/peccancylist";
		}
		//跳转违章页面
			@RequestMapping("/querypeccancy")
				public String querypeccancy(HttpServletRequest req) {
				PublicCar car = this.peccancySercice.querypeccancy(req);
				req.setAttribute("PublicCar", car);
					return "driver/peccancy_add";
				}
			//添加违章信息
				@RequestMapping("/insertpeccancy")
				public String insertpeccancy(HttpServletRequest req,Peccancy peccancy) {
					this.peccancySercice.insertpeccancy(req, peccancy);
					return "driver/peccancy_add";
				}
			//删除违章信息
				@RequestMapping("/deletepeccancy")
				public String deletepeccancy(HttpServletRequest req,Peccancy peccancy) {
			        this.peccancySercice.deletepeccancy(req, peccancy);
					return "redirect:/peccancy/selectpeccancy?currpage=1";
				}	
				
				//违章信息编号查询
				@RequestMapping("/querypeccancyid")
				public String querypeccancyid(HttpServletRequest req,Peccancy peccancy) {
					this.peccancySercice.querypeccancyid(req, peccancy);
					return "driver/peccancylist";
				}		
}
