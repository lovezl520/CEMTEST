package com.cem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cem.pojo.User;
import com.cem.service.UserService;

@Controller
public class RegisterController {
	@Autowired
	private UserService userService;
	@RequestMapping("/register")
	public void register(User user) throws Exception{
		
	}
	/*
	 * 注册时候的检验
	 * 用户名、手机号码、邮箱、学号不能重复；
	 */
	@RequestMapping("/regisCheck")
	public void regisCheck(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String check = request.getParameter("check");
		if(check!=null){
			if(check.equals("username")){//验证用户名是否为一
				User user = userService.findUserByUsername(check, true);//参数为true，说明查找的是已经审核通过的用户
				if(user!=null){//说明系统中已经存在注册且已经审核通过的用户，因而不能用该用户名进行注册
					response.getWriter().write("usernameExist");
				}
			}else if(check.equals("mobile")){//检查注册的手机号是否为一
				
			}
		}
	}
}
