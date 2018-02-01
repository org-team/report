package com.manager.product.po;

import com.utils.BaseModel;
/**
 * 
 * <p>Description: 分类实体</p>
 * <p>Title: Kind.java</p>
 * @date 2018年2月1日
 */
public class Kind extends BaseModel {

	private static final long serialVersionUID = 6020325776183319742L;
	
	private String kindId;
	private String kindName;
	public String getKindId() {
		return kindId;
	}
	public void setKindId(String kindId) {
		this.kindId = kindId;
	}
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	


}
