package com.demo.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.user.dao.UserMapper;
import com.demo.user.service.IUserService;
import com.utils.Msg;

/**
 * @author: zhangKangChuang
 * package: com.demo.service.impl
 * class_name: UserServiceImpl
 * describe: TODO
 * email: 996789881@qq.com
 * @data: 2017/12/26 0026 上午 10:40
 **/
@Service("userService")
public class UserServiceImpl implements IUserService  {
    @Resource
    private UserMapper userMapper;


    @Override
    public Msg queryUserId() {
        Msg msg;
        List<Map<String,Object>> lst=this.userMapper.selectUserId();
        if(null==lst || lst.isEmpty()){
            //查询无结果
            msg=new Msg(Msg.NULL,Msg.NULL_MSG);
        }else{
            msg=new Msg(Msg.SUCCESS,Msg.SUCCESS_MSG,lst);
        }
        return msg;
    }


	@Override
	public Msg insertUserId(String id) {
		Msg msg;
		int nRow=this.userMapper.insertUserId(id);
		if(nRow>0){
			msg=new Msg(Msg.SUCCESS,Msg.SUCCESS_INSERT_MSG);
		}else{
			msg=new Msg(Msg.FAIL,Msg.FAIL_INSERT_MSG);
		}
		return msg;
	}
}
