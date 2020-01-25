package com.han.apple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.han.apple.pojo.Model;
import com.han.apple.service.IModelService;
import com.han.apple.service.ITypeService;

@Controller
public class TypeController {
	
	@Autowired
	private IModelService modelService;
	
	@Autowired
	private ITypeService typeService;
	
	@RequestMapping("/type")
	public ModelAndView type(Integer id) {
		
		ModelAndView mv = new ModelAndView();
		
		// 调用Service层
		Model model = typeService.getById(id);
	
		// 为视图解析器提供ModelAndView(数据和视图)
		// 数据会被放到request对象中
		mv.addObject("title", model); // 提供数据
		
		// 调用Service层获取type为id 这些机型
		@SuppressWarnings("rawtypes")
		List models = modelService.getByType(id);
		
		mv.addObject("models", models);
		
		mv.setViewName("type");
		
		return mv;
	}
}
