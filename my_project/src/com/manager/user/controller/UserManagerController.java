package com.manager.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manager.common.controller.BaseController;
import com.manager.user.po.UserDetail;
import com.manager.user.service.UserManagerService;
import com.utils.JsonUtil;
import com.utils.Md5Tools;
import com.utils.Msg;
import com.utils.Page;
import com.utils.SetSqlId;
import com.utils.TypeIsNull;


/**
 * <p>Description:用户管理模块 </p>
 * <p>Title: UserManagerController.java</p>
 * @date 2018年1月18日
 */
@Controller
@RequestMapping("/usermanager")
public class UserManagerController extends BaseController {
    private static Logger logger = Logger.getLogger(UserManagerController.class);
    @Resource
    private UserManagerService userManagerService;
    
    /**
     * 
     * <p>Title: selectUserInfo_paging</p>
     * <p>Description: 	用户详细信息_分页  </p>
     * @param userName	用户名
     * @param phone		手机号
     * @param roleName	权限名称
     * @param roleId	权限id
     * @param response
     */
    @RequestMapping("/selectUserInfo_paging")
    public void selectUserInfo_paging(UserDetail u,Page page,HttpServletResponse response) {
        Msg msg;
        try {
        	u.setPage(page);
            msg = this.userManagerService.selectUserInfo_paging(u);
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("类-selectUserInfo_paging报错-: " + e);
        }
        logger.error("类-selectUserInfo_paging-返回-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
    }

    /**
     * <p>Title: addUser</p>
     * <p>Description: 手动添加用户</p>
     * @param userId
     * @param userName
     * @param password
     * @param nickName
     * @param roleId
     * @param roleName
     * @param sex
     * @param age
     * @param phone
     * @param email
     * @param response
     */
    @RequestMapping("/addUser")
    public void addUser(UserDetail u,HttpServletResponse response){
    	Msg msg;
        try {
        	if(!TypeIsNull.typeIsNull(u.getUserName(),u.getPhone())){
        		//参数异常
                msg=new Msg(Msg.ERROR,Msg.ERROR_MSG);
        	}else{
        		//uuid
        		u.setUserId(SetSqlId.GetUuid());
        		u.setRoleId(SetSqlId.GetUuid());
        		//MD5加密
        		u.setPassword(Md5Tools.MD5Encode(u.getPassword(),"utf-8",false));
        		msg=this.userManagerService.addUser(u);        		
        	}
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("类-addUser-报错: " + e);
        }
        logger.error("类-addUser-返回-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
    }
    
    /**
     * <p>Title: isExistUserName</p>
     * <p>Description:添加用户时,登录名去重校验  </p>
     * @param userName
     * @param response
     */
    @RequestMapping("/isExistUserName")
    public void isExistUserName(String userName,HttpServletResponse response){
    	Msg msg;
        try {
        	if(!TypeIsNull.typeIsNull(userName)){
        		//参数异常
                msg=new Msg(Msg.ERROR,"请输入用户名");
        	}else{
        	
        		msg=this.userManagerService.isExistUserName(userName);
        	}
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("类-isExistUserName-报错: " + e);
        }
        logger.error("类-isExistUserName-返回-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
    }
    
    /**
     * <p>Title: deleteUserByuserId</p>
     * <p>Description:根据用户id删除用户(非物理删除)</p>
     * @param userId
     * @param response
     */
    @RequestMapping("/deleteUserByuserId")
    public void deleteUserByuserId(String userId,HttpServletResponse response){
    	Msg msg;
        try {
        	if(!TypeIsNull.typeIsNull(userId)){
        		//参数异常
                msg=new Msg(Msg.ERROR,"参数异常");
        	}else{
        	
        		msg=this.userManagerService.deleteUserByuserId(userId);
        	}
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("类-deleteUserByuserId-报错: " + e);
        }
        logger.error("类-deleteUserByuserId-返回-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
    }
    
    /**
     * <p>Title: updateRoleByUserId</p>
     * <p>Description::根据用户id给用户设置权限 </p>
     * @param u
     * @param response
     */
    @RequestMapping("/updateRoleByUserId")
    public void updateRoleByUserId(UserDetail u,HttpServletResponse response){
    	Msg msg;
        try {
        	if(!TypeIsNull.typeIsNull(u.getUserId())){
        		//参数异常
                msg=new Msg(Msg.ERROR,"参数异常");
        	}else{
        	
        		msg=this.userManagerService.updateRoleByUserId(u);
        	}
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("类-updateRoleByUserId-报错: " + e);
        }
        logger.error("类-updateRoleByUserId-返回-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
    }
    
    /**
     * <p>Title: showRoleList</p>
     * <p>Description:回显权限分类 </p>
     * @param response
     */
    @RequestMapping("/showRoleList")
    public void showRoleList(HttpServletResponse response){
    	Msg msg;
        try {
        	msg=this.userManagerService.showRoleList();
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("类-showRoleList-报错: " + e);
        }
        logger.error("类-showRoleList-返回-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
    }
    
}
