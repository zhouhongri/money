package com.publiccar.code.consumption.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.Consumption;
import com.publiccar.code.model.Repair;

public interface ConsumptionDaoInter {
	
	public void selectconsumption(HttpServletRequest req, int intcurrpage);
	
	public List queryconsumption(Integer userid);
	
	public void insertconsumption(Consumption consumption);
	
	public void deleteconsumption(Consumption consumption);

}
