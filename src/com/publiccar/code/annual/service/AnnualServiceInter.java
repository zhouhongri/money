package com.publiccar.code.annual.service;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.Annual;
import com.publiccar.code.model.Consumption;
import com.publiccar.code.model.PublicCar;

public interface AnnualServiceInter {

	    public void selectannual(HttpServletRequest req, String currpage);
		
		public PublicCar queryannual(HttpServletRequest req);
		
		public void insertannual(HttpServletRequest req,Annual annual);
	
		public void deleteannual(HttpServletRequest req,Annual annual);
		
		public void queryannualid(HttpServletRequest req,Annual annual);
}
