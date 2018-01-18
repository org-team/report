package com.manager.user.service;

import com.manager.user.po.UserDetail;
import com.utils.Msg;

public interface RoleManagerService {
	
	/**
	 * <p>Title: selectRoleInfo_paging</p>
	 * <p>Description:权限信息列表-分页 </p>
	 * @param u
	 * @return
	 */
	Msg selectRoleInfo_paging(UserDetail u);
	
	/**
	 * <p>Title: insertRole</p>
	 * <p>Description:后台管理员新增一条权限 </p>
	 * @param u
	 * @return
	 */
	Msg addRole(UserDetail u);
	
	/**
	 * <p>Title: deleteRoleByRoleId</p>
	 * <p>Description:删除权限记录根据权限id  </p>
	 * @param roleId
	 * @return
	 */
	Msg deleteRoleByRoleId(String roleId);
	
	/**
	 * <p>Title: isExistRoleName</p>
	 * <p>Description:去重权限名称 </p>
	 * @param roleName
	 * @return
	 */
	Msg isExistRoleName(String roleName);
}
