package com.demo.dao;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 查询用户id
     * @return
     */
    List<Map<String,Object>> selectUserId();
    
    /**
     * 插入uuid
     * @param id
     * @return
     */
    int insertUserId(String id);
}