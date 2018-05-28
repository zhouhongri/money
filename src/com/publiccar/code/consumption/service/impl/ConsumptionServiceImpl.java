package com.publiccar.code.consumption.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publiccar.code.consumption.dao.ConsumptionDaoInter;
import com.publiccar.code.consumption.service.ConsumptionServiceInter;
import com.publiccar.code.model.Consumption;
import com.publiccar.code.model.PublicCar;
import com.publiccar.code.model.Repair;
import com.publiccar.code.model.User;

@Service
public class ConsumptionServiceImpl implements ConsumptionServiceInter {
	@Autowired
	public ConsumptionDaoInter consumptionDao;
	@Override
	public void selectconsumption(HttpServletRequest req, String currpage) {
		int intcurrpage = Integer.parseInt(currpage);
		this.consumptionDao.selectconsumption(req, intcurrpage);

	}

	@Override
	public PublicCar queryconsumption(HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		List<PublicCar> carlist = this.consumptionDao.queryconsumption(user.getUserId());
		return carlist.get(0);
	}

	@Override
	public void insertconsumption(HttpServletRequest req, Consumption consumption) {
		this.consumptionDao.insertconsumption(consumption);
	}

	@Override
	public void deleteconsumption(HttpServletRequest req, Consumption consumption) {
		this.consumptionDao.deleteconsumption(consumption);

	}

}
