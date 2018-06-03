package com.publiccar.code.income.service;

import javax.servlet.http.HttpServletRequest;

public interface IncomeServiceInter {
	public void queryIncomeDao(HttpServletRequest req, String currpage);
}
