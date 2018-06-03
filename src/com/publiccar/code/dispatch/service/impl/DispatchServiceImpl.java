package com.publiccar.code.dispatch.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publiccar.code.car.dao.CarDaoInter;
import com.publiccar.code.dispatch.dao.DispatchDaoInter;
import com.publiccar.code.dispatch.service.DispatchServiceInter;
import com.publiccar.code.model.Dispatch;
import com.publiccar.code.model.PublicCar;
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
	
	@Override
	public PublicCar querycar(HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		List<PublicCar> carlist = this.dispatchDaoInter.querycar(user.getUserId());
		PublicCar publicCar = carlist.get(0);
		Date a = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		try {
			Date d = sdf.parse(publicCar.getCarAnnualEndtime());
			Date c = sdf.parse(publicCar.getCarInsuranceEndtime());
			sdf.format(a);
			if(d.before(a)){
				publicCar.setCarAnnualStatus("年检已到期");
			}else{
				publicCar.setCarAnnualStatus("年检未到期");
			}
			if(c.before(a)){
				publicCar.setCarInsuranceStatus("保险已到期");
			}else{
				publicCar.setCarInsuranceStatus("保险未到期");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return publicCar;
	}

}
