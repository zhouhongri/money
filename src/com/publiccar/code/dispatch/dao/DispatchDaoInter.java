package com.publiccar.code.dispatch.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.Dispatch;

public interface DispatchDaoInter {
	public void insertDispatchDao(Dispatch dispatch);
	public void queryDispatchDao(HttpServletRequest req, int currpage);
	public int updateDispatchDao(String dispatchStatus,Integer dispatchId);
	
	public List querycar(Integer userid);
}
