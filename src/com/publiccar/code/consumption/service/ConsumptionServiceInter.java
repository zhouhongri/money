package com.publiccar.code.consumption.service;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.Consumption;
import com.publiccar.code.model.PublicCar;



public interface ConsumptionServiceInter {
	
    public void selectconsumption(HttpServletRequest req, String currpage);
	
	public PublicCar queryconsumption(HttpServletRequest req);
	
	public void insertconsumption(HttpServletRequest req,Consumption consumption);
	
	public void deleteconsumption(HttpServletRequest req,Consumption consumption);
	
	public void queryconsumptionid(HttpServletRequest req,Consumption consumption);

}
