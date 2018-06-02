package com.publiccar.code.annual.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publiccar.code.annual.dao.AnnualDaoInter;
import com.publiccar.code.annual.service.AnnualServiceInter;
import com.publiccar.code.consumption.dao.ConsumptionDaoInter;
import com.publiccar.code.model.Annual;
import com.publiccar.code.model.Consumption;
import com.publiccar.code.model.PublicCar;
import com.publiccar.code.model.User;
@Service
public class AnnualServiceImpl implements AnnualServiceInter {
	
	@Autowired
	public  AnnualDaoInter annualdao;
	@Override
	public void selectannual(HttpServletRequest req, String currpage) {
		int intcurrpage = Integer.parseInt(currpage);
		this.annualdao.selectannual(req, intcurrpage);
	}

	@Override
	public PublicCar queryannual(HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		List<PublicCar> carlist = this.annualdao.queryannual(user.getUserId());
		return carlist.get(0);
	}

	@Override
	public void insertannual(HttpServletRequest req, Annual annual) {
		Integer carId = annual.getCarId();
		String annualEndate = annual.getAnnualEndate();
		this.annualdao.updatepubliccardate(carId, annualEndate);
		annual.setAnnualContent("0");
		this.annualdao.insertannual(annual);
	}

	@Override
	public void deleteannual(HttpServletRequest req, Annual annual) {
				this.annualdao.deleteannual(annual);

	}
	@Override
	public void queryannualid(HttpServletRequest req, Annual annual) {
		this.annualdao.queryannualid(annual,req,1);
	}

}
