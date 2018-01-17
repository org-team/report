package com.manager.user.dao;

import java.util.List;
import java.util.Map;

import com.manager.user.po.UserDetail;


public interface UserManagerMapper {
    /**
     * <p>Title: selectUserInfo_paging</p>
     * <p>Description:查询用户详细信息_分页</p>
     * @param u
     * @return
     */
    List<Map<String,Object>> selectUserInfo_paging(UserDetail u);
    
    /**
     * <p>Title: insertUser_1</p>
     * <p>Description:手动添加用户 </p>
     * @param u
     * @return
     */
    int insertUser_1(UserDetail u);
    int insertUser_2(UserDetail u);
    /*int insertUser_3(UserDetail u);*/
    
    /**
     * <p>Title: isExistUserName</p>
     * <p>Description: 添加用户时,登录名去重校验</p>
     * @param userName
     * @return
     */
    Integer isExistUserName(String userName);
    
    /**
     * <p>Title: deleteUserByuserId</p>
     * <p>Description:根据用户id删除用户(非物理删除) </p>
     * @param userId
     * @return
     */
    Integer deleteUserByuserId(String userId);
    
    /**
     * <p>Title: updateRoleByUserId</p>
     * <p>Description:给用户设置权限 </p>
     * @param u
     * @return
     */
    Integer updateRoleByUserId(UserDetail u);
    
    /**
     * <p>Title: showRoleList</p>
     * <p>Description:回显权限分类 </p>
     * @return
     */
    List<Map<String, Object>> showRoleList();
}