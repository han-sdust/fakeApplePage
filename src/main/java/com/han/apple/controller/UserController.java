package com.han.apple.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.han.apple.pojo.User;
import com.han.apple.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ModelAndView login(User user, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		// 调用Service层对登陆进行操作
		try {
			User loginUser = userService.login(user);
			
			// 用户登陆成功
			// 1. 保存登录信息	将登录信息保存到session中
			session.setAttribute("user", loginUser);
			
			// 2. 跳转到主页
			mv.setViewName("redirect:index");
			
		} catch (Exception e) {
			e.printStackTrace();
			// 当login方法抛出异常时，就代表用户登陆失败
			// 返回login页面，并写明错误原因
			mv.addObject("error", e.getMessage());
			mv.setViewName("login");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public ModelAndView register(User user, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		// 调用Service层对注册进行操作
				try {
					User registerUser = userService.register(user);
					
					// 用户注册成功
					// 1. 保存登录信息	将登录信息保存到session中
					session.setAttribute("user", registerUser);
					
					// 2. 跳转到主页
					mv.setViewName("redirect:index");
					
				} catch (Exception e) {
					e.printStackTrace();
					// 当login方法抛出异常时，就代表用户注册失败
					// 返回register页面，并写明错误原因
					mv.addObject("error", e.getMessage());
					mv.setViewName("register");
				}
				
				return mv;
	}
	
	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		// 清空session中保存的用户信息
		session.removeAttribute("user");
		
		return "redirect:index";
	}
	
}
