package com.manager.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;








import com.manager.user.dao.UserManagerMapper;
import com.manager.user.po.UserDetail;
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

    /**
     * 分页查询用户详细信息
     */
    @Override
    public Msg selectUserInfo_paging(UserDetail u) {
        Msg msg;
        List<Map<String,Object>> lst=this.userManagerMapper.selectUserInfo_paging(u);
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

    /**
     * 手动添加用户 
     */
    @Transactional
	@Override
	public Msg addUser(UserDetail u) {
		Msg msg;
		int isExist= userManagerMapper.isExistUserName(u.getUserName());
		if(isExist==0){
			this.userManagerMapper.insertUser_1(u);
			this.userManagerMapper.insertUser_2(u);
			/*this.userManagerMapper.insertUser_3(u);*/
			msg=new Msg(Msg.SUCCESS,Msg.SUCCESS_INSERT_MSG);
		}else{
			msg=new Msg(Msg.FAIL,"用户名重复");
		}
		
		return msg;
	}
    /**
     * 添加用户时,登录名去重校验 
     */
	@Override
	public Msg isExistUserName(String userName) {
		Msg msg;
		Integer isExist=userManagerMapper.isExistUserName(userName);
		if(isExist==0){
			msg=new Msg(Msg.SUCCESS,Msg.SUCCESS_MSG);
		}else{
			msg=new Msg(Msg.FAIL,"用户名重复,重新输入");
		}
		return msg;
	}

	/**
	 * 根据用户id删除用户(非物理删除) 
	 */
	@Override
	public Msg deleteUserByuserId(String userId) {
		Msg msg;
		int nRow=userManagerMapper.deleteUserByuserId(userId);
		if(nRow==1){
			msg=new Msg(Msg.SUCCESS,"删除成功");
		}else{
			msg=new Msg(Msg.FAIL,"删除失败");
		}
		return msg;
	}
	
	/**
	 * 给用户设置权限
	 */
	@Override
	public Msg updateRoleByUserId(UserDetail u) {
		Msg msg;
		int nRow=userManagerMapper.updateRoleByUserId(u);
		if(nRow==1){
			msg=new Msg(Msg.SUCCESS,"权限设置成功");
		}else{
			msg=new Msg(Msg.FAIL,"权限设置失败");
		}
		return msg;
	}

	/**
	 * 回显权限分类
	 */
	@Override
	public Msg showRoleList() {
		Msg msg;
		List<Map<String, Object>> lst=userManagerMapper.showRoleList();
		msg=new Msg(Msg.SUCCESS,Msg.SUCCESS_MSG,lst);
		return msg;
	}

	/**
	 * 登录
	 */
	@Override
	public UserDetail managerLogin(UserDetail u) {
		return userManagerMapper.managerLogin(u);
	}
}
