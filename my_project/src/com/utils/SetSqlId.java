package com.utils;

import java.util.UUID;

public class SetSqlId {
    /**
     * 用uuid生成数据库id
     * @param 
     * @return String uuid
     */
	public static String GetUuid(){
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}
	
}
