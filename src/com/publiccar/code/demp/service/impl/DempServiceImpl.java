package com.publiccar.code.demp.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publiccar.code.demp.dao.DempDaoInter;
import com.publiccar.code.demp.service.DempServiceInter;
import com.publiccar.code.model.Demp;

@Service
public class DempServiceImpl implements DempServiceInter{
	
	@Autowired
	public DempDaoInter dempDaoInter;
	
	@Override
	public Demp getDempByIdService(Demp demp) {
		Demp dempInstance = this.dempDaoInter.getDempByIdDao(demp);
		return dempInstance;
	}

	@Override
	public void insertDempService(Demp demp) {
		this.dempDaoInter.insertDempDao(demp);
	}

	@Override
	public String delDempService(Demp demp) {
		int num = this.dempDaoInter.delDempDao(demp);
		if(num == 1) {
			return "success";
		}else {
			return "false";
		}
	}

	@Override
	public void updateDempService(Demp demp) {
		this.dempDaoInter.updateDempDao(demp);
	}

	@Override
	public void queryDempService(HttpServletRequest req, String currpage) {
		int intcurrpage = Integer.parseInt(currpage);
		this.dempDaoInter.queryDempDao(req, intcurrpage);
	}

	@Override
	public String getDempByNameService(Demp demp) {
		List list = this.dempDaoInter.getDempByNameDao(demp);
		if(list.size()>0) {
			return "exist";
		}else {
			return "noexist";
		}
	}

	@Override
	public List queryDempNameService() {
		List list = this.dempDaoInter.queryDempNameDao();
		return list;
	}

}
