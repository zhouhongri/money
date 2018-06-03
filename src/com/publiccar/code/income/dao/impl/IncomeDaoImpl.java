package com.publiccar.code.income.dao.impl;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.publiccar.code.income.dao.IncomeDaoInter;

import framework.base.BaseDao;
import framework.util.PageUtil;

@Repository
public class IncomeDaoImpl extends BaseDao implements IncomeDaoInter {

	@Override
	public void queryIncomeDao(HttpServletRequest req, int currpage) {
		String sql = "select t1.consumption_money,user.* from (select consumption.*, date_sub(date_sub(date_format(now(),'%y-%m-%d'),interval extract( day from now())-1 day),interval 1 month) as startdate,  " + 
				" date_sub(date_sub(date_format(now(),'%y-%m-%d'),interval extract( day from now()) day),interval 0 month) as enddate from consumption " + 
				" GROUP BY " + 
				" consumption.consumption_id " + 
				" HAVING " + 
				" consumption.consumption_date BETWEEN startdate and enddate) t1 RIGHT JOIN user on user.user_id=t1.driver_id";
		PageUtil pageUtil = new PageUtil();
		pageUtil.doPage(sql, this.getSession(), req, currpage);
	}
	
}
