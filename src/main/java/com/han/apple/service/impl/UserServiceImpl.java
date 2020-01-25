package com.han.apple.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.han.apple.mapper.UserMapper;
import com.han.apple.pojo.User;
import com.han.apple.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User login(User user) throws Exception {
		/**
		 * 1. 从数据库中查询用户信息
		 * 2. 如果查不到，说明账号不存在
		 * 3. 比较密码，如果密码不对，登陆失败
		 * 4. 密码也正确，登陆成功
		 */
		User loginUser = userMapper.selectByName(user.getUsername());
		
		// 验证用户是否存在
		if (loginUser == null) {
			// 用户不存在？
			throw new Exception("用户名不存在");
		}
		
		// 验证密码是否正确
		if (!user.getPassword().equals(loginUser.getPassword())) {
			// 密码不正确
			throw new Exception("密码不正确");
		}
		
		return loginUser;
	}

	@Override
	public User register(User user) throws Exception {
		/**
		 * 1. 从数据库中查询用户信息
		 * 2. 如果查不到，说明账号不存在，开始添加账号
		 * 3. 比较密码，如果两次密码不同，注册失败
		 * 4. 注册成功，登录注册账号
		 */
		
		// 验证用户是否存在
		if (userMapper.selectByName(user.getUsername()) != null) {
			// 用户存在？
			throw new Exception("用户名已存在");
		}
		
		// 验证密码是否正确
		if (!user.getPassword().equals(user.getPassword2())) {
			// 密码不正确
			throw new Exception("两次密码不同");
		}
		
		Integer res = userMapper.insertUser(user);
		
		if (res<0) {
			throw new Exception("注册失败");
		}
		
		User registerUser = user;
		
		return registerUser;
	}

}
