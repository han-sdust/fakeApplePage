package com.han.apple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.han.apple.service.ITypeService;

@Controller // 告诉Spring框架，把这个类创建出一个对象放到bean容器中
public class IndexController {

	@Autowired
	private ITypeService typeService;

	@RequestMapping("/head")
	/**
	 * 这就是SpringMVC中的处理器
	 */
	public ModelAndView head() {

		ModelAndView mv = new ModelAndView();

		// 调用Service层
		@SuppressWarnings("rawtypes")
		List types = typeService.getAll();

		// 为视图解析器提供ModelAndView(数据和视图)
		// 数据会被放到request对象中
		mv.addObject("types", types); // 提供数据
		mv.setViewName("head"); // 提供视图

		return mv;
	}
	
	@RequestMapping("/index")
	/**
	 * 这就是SpringMVC中的处理器
	 */
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView();

		// 调用Service层
		@SuppressWarnings("rawtypes")
		List types = typeService.getAll();

		// 为视图解析器提供ModelAndView(数据和视图)
		// 数据会被放到request对象中
		mv.addObject("types", types); // 提供数据
		mv.setViewName("index"); // 提供视图

		return mv;
	}
	
	@RequestMapping("/tail")
	/**
	 * 这就是SpringMVC中的处理器
	 */
	public ModelAndView tail() {

		ModelAndView mv = new ModelAndView();

		// 调用Service层
		@SuppressWarnings("rawtypes")
		List types = typeService.getAll();

		// 为视图解析器提供ModelAndView(数据和视图)
		// 数据会被放到request对象中
		mv.addObject("types", types); // 提供数据
		mv.setViewName("tail"); // 提供视图

		return mv;
	}
}
