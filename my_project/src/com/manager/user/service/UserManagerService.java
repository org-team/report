package com.manager.user.service;

import com.manager.user.po.UserDetail;
import com.utils.Msg;


/**
 * package: com.demo.service
 * class_name: IUserService
 * describe: 查询用户id
 * @data: 2017/12/26 0026 上午 10:26
 **/
public interface UserManagerService {
	/**
	 * <p>Title: selectUserInfo_paging</p>
	 * <p>Description:分页查询用户详细信息 </p>
	 * @param map
	 * @return
	 */
    Msg selectUserInfo_paging(UserDetail u);
    
    /**
     * <p>Title: addUser</p>
     * <p>Description:后台管理员手动添加用户</p>
     * @param u
     * @return
     */
    Msg addUser(UserDetail u);
    
    /**
     * <p>Title: isExistUserName</p>
     * <p>Description:添加用户时,登录名去重校验 </p>
     * @param userName
     * @return
     */
    Msg isExistUserName(String userName);
    
    /**
     * <p>Title: deleteUserByuserId</p>
     * <p>Description:根据用户id删除用户(非物理删除) </p>
     * @param userId
     * @return
     */
    Msg deleteUserByuserId(String userId);
    
    /**
     * <p>Title: updateRoleByUserId</p>
     * <p>Description:根据用户id给用户设置权限 </p>
     * @param u
     * @return
     */
    Msg updateRoleByUserId(UserDetail u);
    
    /**
     * <p>Title: showRoleList</p>
     * <p>Description:回显权限分类 </p>
     * @return
     */
    Msg showRoleList();
    
}