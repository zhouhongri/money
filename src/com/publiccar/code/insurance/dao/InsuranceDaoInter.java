package com.publiccar.code.insurance.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.Insurance;
import com.publiccar.code.model.Peccancy;

public interface InsuranceDaoInter {
	  public void selectinsurance(HttpServletRequest req, int intcurrpage);
		
		public List queryinsurance(Integer userid);
	//	
		public void insertinsurance(Insurance insurance);
	//	
		public void deleteinsurance(Insurance insurance);
		
		public int updatepubliccardate(Integer carId,String insuranceEnddate);
		
		public void queryinsuranceid(Insurance insurance,HttpServletRequest req, int currpage);

}
