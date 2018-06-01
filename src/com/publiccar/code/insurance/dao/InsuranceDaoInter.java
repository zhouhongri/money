package com.publiccar.code.insurance.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.Insurance;

public interface InsuranceDaoInter {
	  public void selectinsurance(HttpServletRequest req, int intcurrpage);
		
		public List queryinsurance(Integer userid);
	//	
		public void insertinsurance(Insurance insurance);
	//	
		public void deleteinsurance(Insurance insurance);

}
