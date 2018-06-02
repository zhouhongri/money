package com.publiccar.code.peccancy.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publiccar.code.model.Peccancy;
import com.publiccar.code.model.PublicCar;
import com.publiccar.code.model.Repair;
import com.publiccar.code.model.User;
import com.publiccar.code.peccancy.dao.PeccancyDaoInter;
import com.publiccar.code.peccancy.service.PeccancyServiceInter;

@Service
public class PeccancyServiceImpl implements PeccancyServiceInter {
	@Autowired
	public PeccancyDaoInter peccancyDao;
	@Override
	public void selectpeccancy(HttpServletRequest req, String currpage) {
		int intcurrpage = Integer.parseInt(currpage);
		this.peccancyDao.selectpeccancy(req, intcurrpage);

	}

	@Override
	public PublicCar querypeccancy(HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		List<PublicCar> carlist = this.peccancyDao.querypeccancy(user.getUserId());
		return carlist.get(0);
	}

	@Override
	public void insertpeccancy(HttpServletRequest req, Peccancy peccancy) {
		this.peccancyDao.insertpeccancy(peccancy);
	}

	@Override
	public void deletepeccancy(HttpServletRequest req, Peccancy peccancy) {
		this.peccancyDao.deletepeccancy(peccancy);

	}
	@Override
	public void querypeccancyid(HttpServletRequest req,Peccancy peccancy) {
		this.peccancyDao.querypeccancyid(peccancy,req,1);
	}
}
