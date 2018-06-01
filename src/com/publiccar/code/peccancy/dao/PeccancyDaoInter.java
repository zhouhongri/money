package com.publiccar.code.peccancy.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.Peccancy;

public interface PeccancyDaoInter {
	
	public void selectpeccancy(HttpServletRequest req, int intcurrpage);
	
	public List querypeccancy(Integer userid);
	
	public void insertpeccancy(Peccancy peccancy);
	
	public void deletepeccancy(Peccancy peccancy);
}
