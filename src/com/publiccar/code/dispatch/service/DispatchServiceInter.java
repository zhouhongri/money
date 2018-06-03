package com.publiccar.code.dispatch.service;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.Dispatch;
import com.publiccar.code.model.PublicCar;

public interface DispatchServiceInter {
	public void insertDispatchService(HttpServletRequest req, Dispatch dispatch);
	public void queryDispatchService(HttpServletRequest req, String currpage);
	public String updateDispatchService(Dispatch dispatch);
	
	public PublicCar querycar(HttpServletRequest req);
}
