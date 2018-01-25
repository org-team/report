package com.demo.user.dao;

import com.demo.user.po.User;

public interface UserMapper {
   
	/**
     * 插入用户登录信息
     * @param user
     */
	public void insertUser(User user);
    
    /**
     * 插入用户详细信息
     * @param user
     */
	public void insertProfile(User user);
	
	/***
	 * 根据用户名查询用户登录信息，只返回user_id,user_name
	 * @param user_name
	 * @return
	 */
	public User selectUser(String user_name);
	
	/***
	 * 根据用户id查询用户登录信息，返回用户详细信息
	 * @param user_id
	 * @return
	 */
	public User selectProfile(String user_id);
	
	/**
	 * 修改用户密码
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 修改个人信息
	 * @param user
	 */
	public void updateProfile(User user);

}