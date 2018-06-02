package com.publiccar.code.demp.dao.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.publiccar.code.demp.dao.DempDaoInter;
import com.publiccar.code.model.Demp;

import framework.base.BaseDao;
import framework.util.PageUtil;

@Repository
public class DempDaoImpl extends BaseDao implements DempDaoInter {

	@Override
	public Demp getDempByIdDao(Demp demp) {
		Session session = this.getSession();
		Demp dempInstance = (Demp) session.get(demp.getClass(), demp.getDempId());
		return dempInstance;
	}

	@Override
	public void insertDempDao(Demp demp) {
		Session session = this.getSession();
		session.save(demp);
	}

	@Override
	public int delDempDao(Demp demp) {
		Session session = this.getSession();
		String hql = "delete from Demp where dempId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, demp.getDempId());
		return query.executeUpdate();
	}

	@Override
	public void updateDempDao(Demp demp) {
		Session session = this.getSession();
		session.update(demp);
	}

	@Override
	public void queryDempDao(HttpServletRequest req, int currpage) {
		String sql = "select * from demp";
		PageUtil pageUtil = new PageUtil();
		pageUtil.doPage(sql, this.getSession(), req, currpage);
	}

	@Override
	public List getDempByNameDao(Demp demp) {
		Session session = this.getSession();
		String hql = "from Demp where dempName=?";
		Query query = session.createQuery(hql);
		query.setString(0, demp.getDempName());
		return query.list();
	}

	@Override
	public List queryDempNameDao() {
		Session session = this.getSession();
		String hql = "from Demp";
		Query query = session.createQuery(hql);
		return query.list();
	}

}
