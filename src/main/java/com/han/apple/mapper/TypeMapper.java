package com.han.apple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.han.apple.pojo.Model;
import com.han.apple.pojo.Type;

/**
 * 访问数据表Type的操作
 * 
 * @author ex-machina
 *
 */
@Mapper // Mybatis的注解
public interface TypeMapper {
	/**
	 * 查询所有的产品分类
	 * 
	 * @return
	 */
	List<Type> selectAll();
	
	Model selectById(Integer id);
}
