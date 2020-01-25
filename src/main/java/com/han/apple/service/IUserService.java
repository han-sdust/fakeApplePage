package com.han.apple.service;

import com.han.apple.pojo.User;

/**
 * 用户操作的业务
 * @author ex-machina
 *
 */
public interface IUserService {
	/**
	 * 用户登陆的业务处理
	 * @throws Exception 
	 */
	User login(User user) throws Exception;

	User register(User user) throws Exception;
}
