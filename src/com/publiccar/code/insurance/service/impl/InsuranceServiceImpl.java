package com.publiccar.code.insurance.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publiccar.code.insurance.dao.InsuranceDaoInter;
import com.publiccar.code.insurance.service.InsuranceServiceInter;
import com.publiccar.code.model.Insurance;
import com.publiccar.code.model.PublicCar;
import com.publiccar.code.model.User;

@Service
public class InsuranceServiceImpl implements InsuranceServiceInter {
	@Autowired
	public  InsuranceDaoInter insurancedao;
	@Override
	public void selectinsurance(HttpServletRequest req, String currpage) {
		int intcurrpage = Integer.parseInt(currpage);
		this.insurancedao.selectinsurance(req, intcurrpage);
	}

	@Override
	public PublicCar queryinsurance(HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		List<PublicCar> carlist = this.insurancedao.queryinsurance(user.getUserId());
		return carlist.get(0);
	}

	@Override
	public void insertinsurance(HttpServletRequest req, Insurance insurance) {
		this.insurancedao.insertinsurance(insurance);
	}

	@Override
	public void deleteinsurance(HttpServletRequest req, Insurance insurance) {
		this.insurancedao.deleteinsurance(insurance);

	}

}
