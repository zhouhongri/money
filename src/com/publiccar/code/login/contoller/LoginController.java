package com.publiccar.code.login.contoller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.publiccar.code.login.service.LoginServiceInter;
import com.publiccar.code.model.User;

@Controller
@RequestMapping("loginCtrl")
public class LoginController {
	
	@Autowired
	private LoginServiceInter loginService;
	
	@RequestMapping("/login")
	@ResponseBody
	   public Map login(HttpSession session, User user) {
	      return this.loginService.login(session, user);
	}
	
}
