package com.demo.user.service;

import com.demo.user.po.User;
import com.utils.Msg;


/**
 * 该接口用户封装关于用户的所有逻辑操作
 **/
public interface IUserService {
     
	/**
	 * 用户信息注册
	 * @param u
	 * @return
	 */
	public Msg registUser(User u);
	
	/**
	 * 用户登录
	 * @return
	 */
	public Msg loginUser(String user_name,String password);
	
	/**
	 * 查询用户详细信息
	 * @param user_id
	 * @return
	 */
    public Msg getUserDetail(String user_id);
    
    /**
     * 修改密码
     * @param user_name
     * @param old_pwd
     * @param new_pwd
     * @return
     */
    public Msg changePassword(String user_name,String old_pwd,String new_pwd);
    
    /**
     * 修改个人信息
     * @param user
     * @return
     */
    public Msg changeUserDetail(User user);
}