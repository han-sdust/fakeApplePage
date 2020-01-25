package com.han.apple.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.han.apple.pojo.User;

@Mapper
public interface UserMapper {
	
	/**
	 * 查询根据账号和密码
	 */
	User selectByName(String username);

	/**
	 * 添加账号
	 * @param user
	 * @return
	 */
	Integer insertUser(User user);
}
