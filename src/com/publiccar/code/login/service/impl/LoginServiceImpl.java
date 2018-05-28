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
				result.put("mess", "��½�ɹ�");
				session.setAttribute("user", list.get(0));
				if("0".equals(list.get(0).getUserIdentity())){
					result.put("useridentity", "����Ա");
				}else if("1".equals(list.get(0).getUserIdentity())){
					result.put("useridentity", "��ʻԱ");
				}else if("2".equals(list.get(0).getUserIdentity())){
					result.put("useridentity", "�������Ÿ�����");
				}else if("3".equals(list.get(0).getUserIdentity())){
					result.put("useridentity", "�ó���Ա");
				}	
			}else{
				result.put("result", false);
				result.put("mess", "���벻��ȷ");
			}	
		}
		else{
			result.put("result", false);
			result.put("mess", "�û���������");
		}
		return result;
	}

}
