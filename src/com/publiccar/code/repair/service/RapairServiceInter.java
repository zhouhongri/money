package com.publiccar.code.repair.service;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.PublicCar;
import com.publiccar.code.model.Repair;

public interface RapairServiceInter {
	
	public void selectrapair(HttpServletRequest req, String currpage);
	
	public PublicCar queryrapair(HttpServletRequest req);
	
	public void insertrapair(HttpServletRequest req,Repair repair);
	
	public void deleterapair(HttpServletRequest req,Repair repair);
	
	public void queryrapairid(HttpServletRequest req,Repair rapair); 
}
