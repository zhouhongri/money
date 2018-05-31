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

   //������
	@Controller
	@RequestMapping("annual")
    public class AnnualContoller {
		@Autowired
		private  AnnualServiceInter annualservice;
		//��ѯ����б�
		@RequestMapping("/selectannual")
		 public String selectannual(HttpServletRequest req, String currpage) {
		       this.annualservice.selectannual(req, currpage);
		       return "driver/annuallist";
		}
		//��ת����ҳ��
			@RequestMapping("/queryannual")
				public String queryannual(HttpServletRequest req) {
				PublicCar car = this.annualservice.queryannual(req);
				req.setAttribute("PublicCar", car);
					return "driver/annual_add";
				}
			//��������Ϣ
				@RequestMapping("/insertannual")
				public String insertannual(HttpServletRequest req,Annual annual ) {
					this.annualservice.insertannual(req, annual);
					return "driver/annual_add";
				}
			//ɾ�������Ϣ
				@RequestMapping("/deleteannual")
				public String deleteannual(HttpServletRequest req,Annual annual) {
			        this.annualservice.deleteannual(req, annual);
					return "redirect:/annual/selectannual?currpage=1";
				}		

	}

