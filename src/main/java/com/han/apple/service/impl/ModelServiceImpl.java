package com.han.apple.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.han.apple.mapper.ModelMapper;
import com.han.apple.pojo.Model;
import com.han.apple.service.IModelService;

@Service
public class ModelServiceImpl implements IModelService {

	@Autowired
	private ModelMapper modelMapper;

	@SuppressWarnings("rawtypes")
	@Override
	public List getByType(Integer type) {
		return modelMapper.selectByType(type);
	}

	@Override
	public Model getById(Integer id) {
		return modelMapper.selectById(id);
	}

}
