package com.publiccar.code.repair.dao;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.publiccar.code.model.Repair;

public interface RepairDaoInter {
	public void selectrepair(HttpServletRequest req, int currpage);
	
	public List queryrapair(Integer userid);
	
	public void insertrapair(Repair repair);
	
	public void deleterapair(Repair repair);

}
