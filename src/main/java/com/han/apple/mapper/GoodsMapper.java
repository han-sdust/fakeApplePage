package com.han.apple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.han.apple.pojo.Goods;

@Mapper
public interface GoodsMapper {
	
	/**
	 * 根据机型ID，查询商品信息
	 */
	List<Goods> selectByModel(Integer model);

	Goods selectByAll(Goods goods);
	Goods selectById(Integer id);
}
