package com.han.apple.service;

import java.util.List;

import com.han.apple.pojo.Model;
import com.han.apple.pojo.Type;

/**
 * 有关Type的业务处理 逻辑上的操作
 * 
 * @author ex-machina
 *
 */
public interface ITypeService {
	/**
	 * 用来获取所有的产品分类
	 * 
	 * @return
	 */
	List<Type> getAll();

	Model getById(Integer id);
}
