package com.publiccar.code.demp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.publiccar.code.demp.service.DempServiceInter;
import com.publiccar.code.model.Demp;

@Controller
@RequestMapping("dempCtrl")
public class DempController {
	
	@Autowired
	public DempServiceInter dempServiceInter;
	
	@RequestMapping("/queryDemp")
	public String queryDemp(HttpServletRequest req,String currpage) {
		this.dempServiceInter.queryDempService(req, currpage);
		return "admin/demps";
	}
	
	@RequestMapping("/queryDempById")
	public String queryDempByIdCtrl(HttpServletRequest req, Demp demp) {
		Demp dempInstance = this.dempServiceInter.getDempByIdService(demp);
		req.setAttribute("Demp", dempInstance);
		return "admin/demps_update";
	}
	
	@RequestMapping("/updateDemp")
	public String updateDemp(Demp demp) {
		this.dempServiceInter.updateDempService(demp);
		return "redirect:/dempCtrl/queryDemp?currpage=1";
	}
	
	@RequestMapping("/delDempById")
	@ResponseBody
	public String delDempById(Demp demp) {
		String flag = this.dempServiceInter.delDempService(demp);
		return flag;
	}
	
	@RequestMapping("/insertDemp")
	public String insertDemp(Demp demp) {
		this.dempServiceInter.insertDempService(demp);
		return "redirect:/dempCtrl/queryDemp?currpage=1";
	}
	@RequestMapping("/checkDempName")
	@ResponseBody
	public String checkDempName(Demp demp) {
		String flag = this.dempServiceInter.getDempByNameService(demp);
		return flag;
	}
	@RequestMapping("/queryDempName")
	@ResponseBody
	public List<Demp> queryDempName() {
		List<Demp> list = this.dempServiceInter.queryDempNameService();
		return list;
	}
}
