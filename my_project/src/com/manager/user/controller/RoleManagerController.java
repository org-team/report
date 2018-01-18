package com.manager.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.common.controller.BaseController;
import com.manager.user.po.UserDetail;
import com.manager.user.service.RoleManagerService;
import com.utils.JsonUtil;
import com.utils.Msg;
import com.utils.Page;
import com.utils.SetSqlId;
import com.utils.TypeIsNull;

@Controller
@RequestMapping("/roleManager")
public class RoleManagerController extends BaseController {
	private static Logger logger = Logger.getLogger(RoleManagerController.class);
    @Resource
    private RoleManagerService roleManagerService;
    
    /**
     * <p>Title: selectUserInfo_paging</p>
     * <p>Description:权限信息列表-分页  </p>
     * @param u
     * @param page
     * @param response
     */
    @RequestMapping("/selectUserInfo_paging")
    public void selectUserInfo_paging(UserDetail u,Page page,HttpServletResponse response) {
        Msg msg;
        try {
        	u.setPage(page);
            msg = this.roleManagerService.selectRoleInfo_paging(u);
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("类-selectUserInfo_paging报错-: " + e);
        }
        logger.error("类-selectUserInfo_paging-返回-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
    }

    /**
     * <p>Title: addRole</p>
     * <p>Description:添加一条权限记录 </p>
     * @param roleName
     * @param response
     */
    @RequestMapping("/addRole")
    public void addRole(UserDetail u,HttpServletResponse response){
    	Msg msg;
        try {
        	if(!TypeIsNull.typeIsNull(u.getRoleName())){
        		//参数异常
                msg=new Msg(Msg.ERROR,Msg.ERROR_MSG);
        	}else{
        		//uuid
        		u.setRoleId(SetSqlId.GetUuid());
        		msg=this.roleManagerService.addRole(u);
        	}
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("类-addUser-报错: " + e);
        }
        logger.error("类-addUser-返回-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
    }
    
    /**
     * <p>Title: isExistRoleName</p>
     * <p>Description:权限名去重 </p>
     * @param roleName
     * @param response
     */
    @RequestMapping("/isExistRoleName")
    public void isExistRoleName(String roleName,HttpServletResponse response){
    	Msg msg;
        try {
        	if(!TypeIsNull.typeIsNull(roleName)){
        		//参数异常
                msg=new Msg(Msg.ERROR,"请输入用户名");
        	}else{
        	
        		msg=this.roleManagerService.isExistRoleName(roleName);
        	}
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("类-isExistRoleName-报错: " + e);
        }
        logger.error("类-isExistRoleName-返回-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
    }
    
    /**
     * <p>Title: deleteUserByuserId</p>
     * <p>Description:根据用户id删除用户(非物理删除)</p>
     * @param roleId
     * @param response
     */
    @RequestMapping("/deleteRoleByRoleId")
    public void deleteRoleByRoleId(String roleId,HttpServletResponse response){
    	Msg msg;
        try {
        	if(!TypeIsNull.typeIsNull(roleId)){
        		//参数异常
                msg=new Msg(Msg.ERROR,"请先输入权限名称");
        	}else{
        	
        		msg=this.roleManagerService.deleteRoleByRoleId(roleId);
        	}
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("类-deleteRoleByRoleId-报错: " + e);
        }
        logger.error("类-deleteRoleByRoleId-返回-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
    }
}
