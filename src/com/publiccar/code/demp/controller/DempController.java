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
	//查询部门信息
	@RequestMapping("/queryDemp")
	public String queryDemp(HttpServletRequest req,String currpage) {
		this.dempServiceInter.queryDempService(req, currpage);
		return "admin/demps";
	}
	//查询符合条件的部门信息
	@RequestMapping("/queryDempById")
	public String queryDempByIdCtrl(HttpServletRequest req, Demp demp) {
		Demp dempInstance = this.dempServiceInter.getDempByIdService(demp);
		req.setAttribute("Demp", dempInstance);
		return "admin/demps_update";
	}
	//更新部门信息
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
	//新增部门信息
	@RequestMapping("/insertDemp")
	public String insertDemp(Demp demp) {
		this.dempServiceInter.insertDempService(demp);
		return "redirect:/dempCtrl/queryDemp?currpage=1";
	}
	//检查是否存在相同部门
	@RequestMapping("/checkDempName")
	@ResponseBody
	public String checkDempName(Demp demp) {
		String flag = this.dempServiceInter.getDempByNameService(demp);
		return flag;
	}
	//查询所有部门名称
	@RequestMapping("/queryDempName")
	@ResponseBody
	public List<Demp> queryDempName() {
		List<Demp> list = this.dempServiceInter.queryDempNameService();
		return list;
	}
}
