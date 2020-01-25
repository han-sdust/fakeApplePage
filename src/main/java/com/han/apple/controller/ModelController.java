package com.han.apple.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.han.apple.pojo.Goods;
import com.han.apple.pojo.Model;
import com.han.apple.pojo.User;
import com.han.apple.service.IGoodsService;
import com.han.apple.service.IModelService;

@Controller
public class ModelController {


	@Autowired
	private IModelService modelService;
	
	@Autowired
	private IGoodsService goodsService;
	
	@RequestMapping("/model")
	public ModelAndView model(Integer id) {
		
		ModelAndView mv = new ModelAndView();
		
		// 调用Service层，获取当前model的详细信息
		Model model = modelService.getById(id);
		
		// 调用Service层，获取当前机型下的商品信息 Goods
		List<Goods> goodsList = goodsService.getByModel(id);
		
		mv.addObject("model", model);
		
		mv.addObject("goodsList", goodsList);
		
		// 尺寸
		Set<Double> sizes = new HashSet<>();
		// 颜色
		Set<String> colors = new HashSet<>();
		// 内存
		Set<Integer> memories = new HashSet<>();
		
		Integer partPrice = model.getPrice()/24;

		for ( Goods goods : goodsList ) {
			sizes.add(goods.getSize());
			colors.add(goods.getColor());
			memories.add(goods.getMemory());
		}
		
		mv.addObject("sizes", sizes);
		mv.addObject("colors", colors);
		mv.addObject("memories", memories);
		mv.addObject("partPrice", partPrice);
		
		
		mv.setViewName("model");
		
		return mv;
	}
	
	@RequestMapping("/buy")
	@ResponseBody
	public String buy(Goods goods, HttpSession session) {
		
		// 判断当前用户是否登录
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "{\"res\": -1}";
		}
		
		// 当前用户购买Goods是哪一个
		Goods resGoods = goodsService.getByAll(goods);
		
		if (resGoods != null) {
			// 商品存在
			return "{\"res\": 1, \"goods\": "+resGoods.getId()+"}";
		} else {
			// 商品不存在
			return "{\"res\": -2}";
		}
		
	}
	
}
