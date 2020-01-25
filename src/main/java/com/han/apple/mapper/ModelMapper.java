package com.han.apple.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.han.apple.pojo.Model;

@Mapper
public interface ModelMapper {
	
	/**
	 * 根据类型查询机型
	 */
	@SuppressWarnings("rawtypes")
	List<Map> selectByType(Integer type);

	/**
	 * 根据ID查询机型的信息
	 * @param id
	 * @return
	 */
	Model selectById(Integer id);

}
