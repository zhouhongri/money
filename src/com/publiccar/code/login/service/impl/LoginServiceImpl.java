package com.publiccar.code.login.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publiccar.code.login.dao.LoginDaoInter;
import com.publiccar.code.login.service.LoginServiceInter;
import com.publiccar.code.model.User;

@Service
public class LoginServiceImpl implements LoginServiceInter {
	
	@Autowired
	public LoginDaoInter loginDao;
	@Override
	public Map<String, Object> login(
			HttpSession session, User user) {
		// TODO Auto-generated method stub
		Map<String,Object> result = new HashMap<String, Object>();
		List<User> list = loginDao.getUserByName(user.getUserUsername());
		if(list.size()>0&&list!=null){
			if(user.getUserPassword().equals(list.get(0).getUserPassword())){
				result.put("result",true);
				result.put("mess", "登陆成功");
				session.setAttribute("user", list.get(0));
				if("0".equals(list.get(0).getUserIdentity())){
					result.put("useridentity", "管理员");
				}else if("1".equals(list.get(0).getUserIdentity())){
					result.put("useridentity", "驾驶员");
				}else if("2".equals(list.get(0).getUserIdentity())){
					result.put("useridentity", "车辆部门负责人");
				}else if("3".equals(list.get(0).getUserIdentity())){
					result.put("useridentity", "用车官员");
				}	
			}else{
				result.put("result", false);
				result.put("mess", "密码不正确");
			}	
		}
		else{
			result.put("result", false);
			result.put("mess", "用户名不存在");
		}
		return result;
	}

}
