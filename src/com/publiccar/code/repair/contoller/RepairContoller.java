 package com.publiccar.code.repair.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.publiccar.code.model.PublicCar;
import com.publiccar.code.model.Repair;
import com.publiccar.code.repair.service.RapairServiceInter;


//维修管理
@Controller
@RequestMapping("rapairCtrl")
public class RepairContoller {
	
	@Autowired
	private RapairServiceInter repairSercice;
	//查询维修信息
	@RequestMapping("/selectrapair")
	 public String selectrapair(HttpServletRequest req, String currpage) {
	       this.repairSercice.selectrapair(req, currpage);
	       return "driver/repairlist";
	}
	//跳转到添加维修信息页面
	@RequestMapping("/queryrapair")
		public String queryrapair(HttpServletRequest req) {
		PublicCar car = this.repairSercice.queryrapair(req);
		req.setAttribute("PublicCar", car);
			return "driver/repaira_add";
		}
	//维修信息添加
		@RequestMapping("/insertrapair")
		public String insertrapair(HttpServletRequest req,Repair repair) {
			this.repairSercice.insertrapair(req, repair);
			return "driver/repaira_add";
	}	
		//删除维修信息
		@RequestMapping("/deleterapair")
		public String deleterapair(HttpServletRequest req,Repair rapair) {
	        this.repairSercice.deleterapair(req, rapair);
			return "redirect:/rapairCtrl/selectrapair?currpage=1";
		}		
		
		//维修信息编号查询
		@RequestMapping("/queryrapairid")
		public String queryrapairid(HttpServletRequest req,Repair rapair) {
			this.repairSercice.queryrapairid(req, rapair);
			return "driver/repairlist";
		}		
}
