package com.publiccar.code.insurance.service;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.Insurance;
import com.publiccar.code.model.PublicCar;

public interface InsuranceServiceInter {
	
	public void selectinsurance(HttpServletRequest req, String currpage);
		
		public PublicCar queryinsurance(HttpServletRequest req);
//		
		public void insertinsurance(HttpServletRequest req,Insurance insurance);
//		
		public void deleteinsurance(HttpServletRequest req,Insurance insurance);

}
