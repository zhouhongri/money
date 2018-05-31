package com.publiccar.code.annual.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.Annual;
import com.publiccar.code.model.Consumption;

public interface AnnualDaoInter {

    public void selectannual(HttpServletRequest req, int intcurrpage);
	
	public List queryannual(Integer userid);
//	
	public void insertannual( Annual annual);
//	
	public void deleteannual(Annual annual);

}
