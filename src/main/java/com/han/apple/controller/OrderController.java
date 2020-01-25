package com.han.apple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.han.apple.pojo.Goods;
import com.han.apple.service.IGoodsService;

@Controller
public class OrderController {
	
	@Autowired
	private IGoodsService goodsService;
	
	@RequestMapping("/order")
	public ModelAndView order(Integer goods) {
		
		ModelAndView mv = new ModelAndView();
		
		// 获取商品信息
		Goods g = goodsService.GetById(goods);
		
		mv.addObject("goods", g);
		
		mv.setViewName("order");
		
		return mv;
	}
}
