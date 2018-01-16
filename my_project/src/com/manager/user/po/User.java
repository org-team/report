package com.manager.user.po;

import com.utils.BaseModel;

public class User extends BaseModel {
   
	private static final long serialVersionUID = 1L;
	private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}