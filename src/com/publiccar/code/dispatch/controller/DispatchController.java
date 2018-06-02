package com.publiccar.code.dispatch.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.publiccar.code.dispatch.service.DispatchServiceInter;
import com.publiccar.code.model.Dispatch;
import com.publiccar.code.model.User;
import com.publiccar.code.user.service.UserServiceInter;

@Controller
@RequestMapping("dispatchCtrl")
public class DispatchController {
	
	@Autowired
	public DispatchServiceInter dispatchServiceInter;
	@Autowired
	public UserServiceInter userServiceInter;
	
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
		String userIdentity = user.getUserIdentity();
		if("2".equals(userIdentity)) {
			return "driverdemp/dispatchs";
		}else if("1".equals(userIdentity)) {
			return "driver/dispatchs";
		}else {
			return "officials/dispatchs";
		}
	}
	//更新dispatch表、审核
	@RequestMapping("/updateDispatch")
	@ResponseBody
	public String updatedispatchCtrl(Dispatch dispatch) {
		String flag = this.dispatchServiceInter.updateDispatchService(dispatch);
		return flag;
	}
}
