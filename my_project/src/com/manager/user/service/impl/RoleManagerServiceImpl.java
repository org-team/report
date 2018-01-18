package com.manager.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manager.user.dao.RoleManagerMapper;
import com.manager.user.po.UserDetail;
import com.manager.user.service.RoleManagerService;
import com.utils.Msg;
@Service("roleManagerService")
public class RoleManagerServiceImpl implements RoleManagerService {

	@Resource
	private RoleManagerMapper roleManagerMapper;
	
	/**
	 * 权限列表
	 */
	@Override
	public Msg selectRoleInfo_paging(UserDetail u) {
		Msg msg;
        List<Map<String,Object>> lst=this.roleManagerMapper.selectRoleInfo_paging(u);
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
	 * 新增权限
	 */
	@Override
	public Msg addRole(UserDetail u) {
		Msg msg;
		int isExist= roleManagerMapper.isExistRoleName(u.getRoleName());
		if(isExist==0){
			this.roleManagerMapper.insertRole(u);
			msg=new Msg(Msg.SUCCESS,Msg.SUCCESS_INSERT_MSG);
		}else{
			msg=new Msg(Msg.FAIL,"用户名重复");
		}
		return msg;
	}

	@Override
	public Msg deleteRoleByRoleId(String roleId) {
		Msg msg;
		int nRow=roleManagerMapper.deleteRoleByRoleId(roleId);
		if(nRow==1){
			msg=new Msg(Msg.SUCCESS,"删除成功");
		}else{
			msg=new Msg(Msg.FAIL,"删除失败");
		}
		return msg;
	}

	/**
	 * 前台blur事件去重
	 */
	@Override
	public Msg isExistRoleName(String roleName) {
		Msg msg;
		Integer isExist=roleManagerMapper.isExistRoleName(roleName);
		if(isExist==0){
			msg=new Msg(Msg.SUCCESS,Msg.SUCCESS_MSG);
		}else{
			msg=new Msg(Msg.FAIL,"用户名重复,重新输入");
		}
		return msg;
	}

}
