package com.publiccar.code.dispatch.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publiccar.code.car.dao.CarDaoInter;
import com.publiccar.code.dispatch.dao.DispatchDaoInter;
import com.publiccar.code.dispatch.service.DispatchServiceInter;
import com.publiccar.code.model.Dispatch;
import com.publiccar.code.model.User;

@Service
public class DispatchServiceImpl implements DispatchServiceInter{
	
	@Autowired
	public DispatchDaoInter dispatchDaoInter;
	@Autowired
	public CarDaoInter carDaoInter;

	@Override
	public void insertDispatchService(HttpServletRequest req, Dispatch dispatch) {
		carDaoInter.updateStatusById("3", dispatch.getCarId());
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		dispatch.setApplicantName(user.getUserName());
		dispatch.setApplicantSex(user.getUserSex());
		dispatch.setApplicantAge(user.getUserAge());
		dispatch.setDispatchStatus("0");
		dispatch.setUserId(user.getUserId());
		this.dispatchDaoInter.insertDispatchDao(dispatch);
	}

	@Override
	public void queryDispatchService(HttpServletRequest req, String currpage) {
		int intcurrpage = Integer.parseInt(currpage);
		this.dispatchDaoInter.queryDispatchDao(req, intcurrpage);
	}

	@Override
	public String updateDispatchService(Dispatch dispatch) {
		int num = 0;
		String status="0";
		if("通过".equals(dispatch.getDispatchStatus())) {
			status = "1";
		}else if("未通过".equals(dispatch.getDispatchStatus())) {
			carDaoInter.updateStatusById("0", dispatch.getCarId());
			status = "2";
		}else if("已完成".equals(dispatch.getDispatchStatus())) {
			carDaoInter.updateStatusById("0", dispatch.getCarId());
			status = "3";
		}
		num = this.dispatchDaoInter.updateDispatchDao(status, dispatch.getDispatchId());
		if(num==1) {
			return "success";
		}else {
			return "false";
		}
	}
	
}
