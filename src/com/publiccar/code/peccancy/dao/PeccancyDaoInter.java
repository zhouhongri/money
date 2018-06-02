package com.publiccar.code.peccancy.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.Peccancy;
import com.publiccar.code.model.Repair;

public interface PeccancyDaoInter {
	
	public void selectpeccancy(HttpServletRequest req, int intcurrpage);
	
	public List querypeccancy(Integer userid);
	
	public void insertpeccancy(Peccancy peccancy);
	
	public void deletepeccancy(Peccancy  peccancy);
	
	public void querypeccancyid(Peccancy peccancy,HttpServletRequest req, int currpage);
}
