package com.han.apple.service;

import java.util.List;

import com.han.apple.pojo.Goods;

public interface IGoodsService {
	
	/**
	 * 根据机型，查询商品
	 * @return
	 */
	List<Goods> getByModel(Integer model);

	Goods getByAll(Goods goods);

	Goods GetById(Integer goods);

}
