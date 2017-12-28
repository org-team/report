package com.demo.user.dao;

import java.util.List;
import java.util.Map;

import com.demo.user.po.User;

public interface UserMapper {
    /**
     * 查询用户id
     * @return
     */
    List<Map<String,Object>> selectUserId_paging(User user);
    
    /**
     * 插入uuid
     * @param id
     * @return
     */
    int insertUserId(String id);
}