package com.demo.user.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.demo.user.dao.UserMapper;
import com.demo.user.po.User;
import com.demo.user.service.IUserService;
import com.utils.Md5Tools;
import com.utils.Msg;
import com.utils.SetSqlId;

/**
 *
 **/
@Service("userService")
public class UserServiceImpl implements IUserService  {
   
	private Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Resource
    private UserMapper userMapper;

    @Override
    public Msg registUser(User u) {
        Msg msg;//返回结果
        try{
        	//首先判断该用户是否已经存在
        	User user = userMapper.selectUser(u.getUser_name().trim());//查询用户信息
        	if(null != user){
        		msg = new Msg(Msg.FAIL,"该用户已存在");
        	}else{
        		//首先补充参数中缺少部分，user_id,create_time,update_time
                u.setUser_id(SetSqlId.GetUuid());
                u.setCreate_time(new Date());
                u.setUpdate_time(u.getCreate_time());//注册保证创建时间和修改时间一致
                //将用户注册总密码部分采用md5加密
                u.setPassword(Md5Tools.MD5Encode(u.getPassword(), "UTF-8", false));
                //保证昵称的存在
                if("".equals(u.getNick_name()) || null == u.getNick_name()){
                	u.setNick_name("YC_" + u.getUser_name());//用户昵称初始为"YC_"和用户名的组合（当用户注册不填写内容时）
                }
            	//将数据插入用户表
            	userMapper.insertUser(u);
            	//将数据插入用户详情表
            	userMapper.insertProfile(u);
            	msg = new Msg(Msg.SUCCESS,"注册成功");
        	}
        }catch(Exception e){
        	msg = new Msg(Msg.FAIL,"注册失败");
        	logger.error("注册失败。。。" + e);
        }
        return msg;
    }

	@Override
	public Msg loginUser(String user_name, String password) {
		Msg msg;//返回结果
		try{
			User user = userMapper.selectUser(user_name.trim());//查询用户登录信息
			if(null != user){
				//将密码采用md5加密
				String pwd = Md5Tools.MD5Encode(password, "UTF-8", false);
				if(pwd.equals(user.getPassword())){
					msg = new Msg(Msg.SUCCESS,Msg.SUCCESS_MSG,user);
				}else{
					msg = new Msg(Msg.NULL,"密码错误");
				}
			}else{
				msg = new Msg(Msg.NULL,"用户不存在");
			}
		}catch(Exception e){
			msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
			logger.error("登录失败。。。" + e);
		}
		return msg;
	}

	@Override
	public Msg getUserDetail(String user_id) {
		Msg msg;//返回结果
		try{
			User user = userMapper.selectProfile(user_id.trim());//查询用户详细信息
			if(null != user){
				msg = new Msg(Msg.SUCCESS,Msg.SUCCESS_MSG,user);
			}else{
				msg = new Msg(Msg.NULL,"用户不存在");
			}
		}catch(Exception e){
			msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
			logger.error("获取用户详细信息失败。。。" + e);
		}
		return msg;
	}

	@Override
	public Msg changePassword(String user_name, String old_pwd, String new_pwd) {
		Msg msg;//返回结果
		try{
			User user = userMapper.selectUser(user_name.trim());//查询用户登录信息
			String old_password = Md5Tools.MD5Encode(old_pwd, "UTF-8", false);//加密旧密码
			String new_password = Md5Tools.MD5Encode(new_pwd, "UTF-8", false);//加密新密码
			if(null != user && old_password.equals(user.getPassword())){
				User u = new User();//生成修改参数
				u.setUser_name(user_name);
				u.setPassword(new_password);
				userMapper.updateUser(user);
				msg = new Msg(Msg.SUCCESS,"密码修改成功");
			}else{
				msg = new Msg(Msg.NULL,"密码错误");
			}
		}catch(Exception e){
			msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
			logger.error("密码修改失败。。。" + e);
		}
		return msg;
	}

	@Override
	public Msg changeUserDetail(User user) {
		Msg msg;//返回结果
		try{
			//将用户信息最后更新时间修改为当前时间
			user.setUpdate_time(new Date());
			userMapper.updateProfile(user);
			msg = new Msg(Msg.SUCCESS,"用户信息修改成功");
		}catch(Exception e){
			msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
			logger.error("用户信息修改失败。。。" + e);
		}
		return msg;
	}
}
