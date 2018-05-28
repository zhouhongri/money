package com.publiccar.code.repair.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publiccar.code.model.PublicCar;
import com.publiccar.code.model.Repair;
import com.publiccar.code.model.User;
import com.publiccar.code.repair.dao.RepairDaoInter;
import com.publiccar.code.repair.service.RapairServiceInter;
@Service
public class RapairServiceImpl implements RapairServiceInter {	
	@Autowired
	public RepairDaoInter repairDao;
	@Override
	public void selectrapair(HttpServletRequest req, String currpage){
		int intcurrpage = Integer.parseInt(currpage);
		this.repairDao.selectrepair(req, intcurrpage);
	}

	@Override
	public PublicCar queryrapair(HttpServletRequest req){
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		List<PublicCar> carlist = this.repairDao.queryrapair(user.getUserId());
		return carlist.get(0);
	}
	@Override
	public void insertrapair(HttpServletRequest req,Repair repair){
		
		this.repairDao.insertrapair(repair);
	}
	
	@Override
	public void deleterapair(HttpServletRequest req,Repair repair){
		this.repairDao.deleterapair(repair);
	}
}
