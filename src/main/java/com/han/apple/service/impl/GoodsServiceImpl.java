package com.han.apple.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.han.apple.mapper.GoodsMapper;
import com.han.apple.pojo.Goods;
import com.han.apple.service.IGoodsService;

@Service
public class GoodsServiceImpl implements IGoodsService{

	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public List<Goods> getByModel(Integer model) {
		return goodsMapper.selectByModel(model);
	}

	@Override
	public Goods getByAll(Goods goods) {
		return goodsMapper.selectByAll(goods);
	}

	@Override
	public Goods GetById(Integer goods) {
		return goodsMapper.selectById(goods);
	}
	
}
