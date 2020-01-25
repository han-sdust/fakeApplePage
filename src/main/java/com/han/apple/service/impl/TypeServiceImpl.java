package com.han.apple.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.han.apple.mapper.TypeMapper;
import com.han.apple.pojo.Model;
import com.han.apple.pojo.Type;
import com.han.apple.service.ITypeService;

@Service // 告诉Spring框架，把这个类创建出一个对象放到Bean容器中
public class TypeServiceImpl implements ITypeService {

	@Autowired // 自动注入
	private TypeMapper typeMapper;

	@Override
	public List<Type> getAll() {

		return typeMapper.selectAll();
	}

	@Override
	public Model getById(Integer id) {
		return typeMapper.selectById(id);
	}

}
