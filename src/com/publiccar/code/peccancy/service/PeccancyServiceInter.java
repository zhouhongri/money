package com.publiccar.code.peccancy.service;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.Peccancy;
import com.publiccar.code.model.PublicCar;

public interface PeccancyServiceInter {

	//��ѯ�ͺ���Ϣ
    public void selectpeccancy(HttpServletRequest req, String currpage);
	
	public PublicCar querypeccancy(HttpServletRequest req);
	
	public void insertpeccancy(HttpServletRequest req,Peccancy peccancy);
	
	public void deletepeccancy(HttpServletRequest req,Peccancy peccancy);

}
