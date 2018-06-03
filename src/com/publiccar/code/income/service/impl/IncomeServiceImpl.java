package com.publiccar.code.income.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publiccar.code.income.dao.IncomeDaoInter;
import com.publiccar.code.income.service.IncomeServiceInter;

@Service
public class IncomeServiceImpl implements IncomeServiceInter {
	
	@Autowired
	public IncomeDaoInter incomeDaoInter;
	
	@Override
	public void queryIncomeDao(HttpServletRequest req, String currpage) {
		this.incomeDaoInter.queryIncomeDao(req, Integer.parseInt(currpage));
	}

}
