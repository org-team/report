package com.manager.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;





import com.manager.user.dao.UserManagerMapper;
import com.manager.user.po.User;
import com.manager.user.service.UserManagerService;
import com.utils.Msg;

/**
 * @author: zhangKangChuang
 * package: com.demo.service.impl
 * class_name: UserServiceImpl
 * describe: TODO
 * email: 996789881@qq.com
 * @data: 2017/12/26 0026 上午 10:40
 **/
@Service("userManagerService")
public class UserManagerServiceImpl implements UserManagerService  {
    @Resource
    private UserManagerMapper userManagerMapper;


    @Override
    public Msg queryUserId(User u) {
        Msg msg;
        List<Map<String,Object>> lst=this.userManagerMapper.selectUserId_paging(u);
        if(null==lst || lst.isEmpty()){
            //查询无结果
            msg=new Msg(Msg.NULL,Msg.NULL_MSG);
        }else{
            Map<String, Object> map=new HashMap<String, Object>();
            
            map.put("lst", lst);
            map.put("page", u.getPage());
            
            msg=new Msg(Msg.SUCCESS,Msg.SUCCESS_MSG,map);
        }
        return msg;
    }


	@Override
	public Msg insertUserId(String id) {
		Msg msg;
		int nRow=this.userManagerMapper.insertUserId(id);
		if(nRow>0){
			msg=new Msg(Msg.SUCCESS,Msg.SUCCESS_INSERT_MSG);
		}else{
			msg=new Msg(Msg.FAIL,Msg.FAIL_INSERT_MSG);
		}
		return msg;
	}
}
