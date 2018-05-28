 package com.publiccar.code.repair.contoller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.publiccar.code.model.Dispatch;
import com.publiccar.code.model.PublicCar;
import com.publiccar.code.model.Repair;
import com.publiccar.code.model.User;
import com.publiccar.code.repair.service.RapairServiceInter;


//ά�޹���
@Controller
@RequestMapping("rapairCtrl")
public class RepairContoller {
	
	@Autowired
	private RapairServiceInter repairSercice;
	//��ѯά����Ϣ
	@RequestMapping("/selectrapair")
	 public String selectrapair(HttpServletRequest req, String currpage) {
	       this.repairSercice.selectrapair(req, currpage);
	       return "driver/repairlist";
	}
	//��ת�����ά����Ϣҳ��
	@RequestMapping("/queryrapair")
		public String queryrapair(HttpServletRequest req) {
		PublicCar car = this.repairSercice.queryrapair(req);
		req.setAttribute("PublicCar", car);
			return "driver/repaira_add";
		}
	//ά����Ϣ���
		@RequestMapping("/insertrapair")
		public String insertrapair(HttpServletRequest req,Repair repair) {
			this.repairSercice.insertrapair(req, repair);
			return "driver/repaira_add";
		}
	//ɾ��ά�޼�¼
		@RequestMapping("/deleterapair")
		public String deleterapair(HttpServletRequest req,Repair repair) {
	        this.repairSercice.deleterapair(req, repair);
			return "redirect:/rapairCtrl/selectrapair?currpage=1";
		}		
}
