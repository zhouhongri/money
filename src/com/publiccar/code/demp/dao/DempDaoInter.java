package com.publiccar.code.demp.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.Demp;

public interface DempDaoInter {
	public Demp getDempByIdDao(Demp demp);
	public void insertDempDao(Demp demp);
	public int delDempDao(Demp demp);
	public void updateDempDao(Demp demp);
	public void queryDempDao(HttpServletRequest req,int currpage);
	public List getDempByNameDao(Demp demp);
	public List queryDempNameDao();
}
