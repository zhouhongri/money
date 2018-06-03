package com.publiccar.code.income.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.publiccar.code.income.service.IncomeServiceInter;

@Controller
@RequestMapping("incomeCtrl")
public class IncomeController {
	
	@Autowired
	public IncomeServiceInter incomeServiceInter;
	//查询收入信息
	@RequestMapping("queryIncome")
	public String queryIncome(HttpServletRequest req, String currpage) {
		this.incomeServiceInter.queryIncomeDao(req, currpage);
		return "driverdemp/income";
	}
}
