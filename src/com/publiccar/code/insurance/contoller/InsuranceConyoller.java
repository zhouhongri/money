package com.publiccar.code.insurance.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.publiccar.code.insurance.service.InsuranceServiceInter;
import com.publiccar.code.model.Insurance;
import com.publiccar.code.model.PublicCar;

	
  //保险管理
	@Controller
	@RequestMapping("insurance")
	public class InsuranceConyoller {
		@Autowired
		private  InsuranceServiceInter insuranceservice;
		//查询保险记录
		@RequestMapping("/selectinsurance")
		 public String selectinsurance(HttpServletRequest req, String currpage) {
		       this.insuranceservice.selectinsurance(req, currpage);
		       return "driver/insurancelist";
		}
		//跳转新增保险页面 
			@RequestMapping("/queryinsurance")
				public String queryinsurance(HttpServletRequest req) {
				PublicCar car = this.insuranceservice.queryinsurance(req);
				req.setAttribute("PublicCar", car);
					return "driver/insurance_add";
				}
			//新增保险
				@RequestMapping("/insertinsurance")
				public String insertinsurance(HttpServletRequest req,Insurance insurance ) {
					this.insuranceservice.insertinsurance(req, insurance);
					return "driver/insurance_add";
				}
			//删除保险
				@RequestMapping("/deleteinsurance")
				public String deleteinsurance(HttpServletRequest req,Insurance insurance) {
			        this.insuranceservice.deleteinsurance(req, insurance);
					return "redirect:/insurance/selectinsurance?currpage=1";
				}	
				//违章信息编号查询
				@RequestMapping("/queryinsuranceid")
				public String queryinsuranceid(HttpServletRequest req,Insurance insurance) {
					this.insuranceservice.queryinsuranceid(req, insurance);
					return "driver/insurancelist";
				}		

}
