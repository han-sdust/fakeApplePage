package com.han.apple.service;

import java.util.List;

import com.han.apple.pojo.Model;

/**
 * 针对机型的操作
 * @author ex-machina
 *
 */
public interface IModelService {
	/**
	 * 根据类别的id获取相应的机型
	 */
	@SuppressWarnings("rawtypes")
	List getByType(Integer type);

	/**
	 * 根据Model的ID获取详细信息
	 * @param id
	 * @return
	 */
	Model getById(Integer id);

}
