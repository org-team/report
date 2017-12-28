package com.demo.user.service;

import com.demo.user.po.User;
import com.utils.Msg;


/**
 * @author: zhangKangChuang
 * package: com.demo.service
 * class_name: IUserService
 * describe: 查询用户id
 * email: 996789881@qq.com
 * @data: 2017/12/26 0026 上午 10:26
 **/
public interface IUserService {
    Msg queryUserId(User u);
    
    Msg insertUserId(String id);
    
}