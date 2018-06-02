package com.publiccar.code.demp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.Demp;

public interface DempServiceInter {
	public Demp getDempByIdService(Demp demp);
	public void insertDempService(Demp demp);
	public String delDempService(Demp demp);
	public void updateDempService(Demp demp);
	public void queryDempService(HttpServletRequest req,String currpage);
	public String getDempByNameService(Demp demp);
	public List queryDempNameService();
}
