package com.publiccar.code.dispatch.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.publiccar.code.dispatch.service.DispatchServiceInter;
import com.publiccar.code.model.Dispatch;
import com.publiccar.code.model.User;

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
		User user = (User) req.getSession().getAttribute("user");
		String dempname = user.getUserDemp();
		if("车辆部门".equals(dempname)) {
			return "driverdemp/dispatchs";
		}else if("".equals(dempname) && dempname==null) {
			return "officials/dispatchs";
		}else {
			return "driver/dispatchs";
		}
	}
	//更新dispatch表、审核
	@RequestMapping("/updateDispatch")
	public String updatedispatchCtrl(HttpServletRequest req,String dispatchId) {
		System.out.println(dispatchId);
		return null;
//		this.dispatchServiceInter.insertDispatchService(req, dispatch);
//		return "redirect:/dispatchCtrl/queryDispatch?currpage=1";
	}
}
