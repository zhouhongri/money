package com.publiccar.code.dispatch.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.publiccar.code.dispatch.service.DispatchServiceInter;
import com.publiccar.code.model.Dispatch;

@Controller
@RequestMapping("dispatchCtrl")
public class DispatchController {
	
	@Autowired
	public DispatchServiceInter dispatchServiceInter;
	
	//申请车数据辆插入dispatch表
	@RequestMapping("/insertDispatch")
	public String dispatchCtrl(HttpServletRequest req,Dispatch dispatch) {
		this.dispatchServiceInter.insertDispatchService(req, dispatch);
		return "redirect:/dispatchCtrl/queryDispatch?currpage=1";
	}
	//查询申请车记录
	@RequestMapping("/queryDispatch")
	public String queryDispatchCtrl(HttpServletRequest req, String currpage) {
		this.dispatchServiceInter.queryDispatchService(req, currpage);
		return "officials/dispatchs";
	}
}
