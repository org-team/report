package com.manager.product.dao;

import java.util.List;
import java.util.Map;

import com.manager.product.po.Kind;



public interface KindManagerMapper {
	/**
	 * <p>Title: selectKind__paging</p>
	 * <p>Description: 查看所有商品分类</p>
	 * @return
	 */
	List<Map<String,Object>> selectKind__paging(Kind k);
	
	/**
	 * 添加分类
	 * <p>Title: insertKind</p>
	 * <p>Description: </p>
	 * @param k
	 * @return
	 */
	int insertKind(Kind k);
	
	/**
	 * 去重
	 * <p>Title: isExitKindName</p>
	 * <p>Description: </p>
	 * @param kindName
	 * @return
	 */
	int isExitKindName(String kindName);
	
	/**
	 * 删除分类
	 * <p>Title: deleteKindName2id</p>
	 * <p>Description: </p>
	 * @param kindId
	 * @return
	 */
	int deleteKindName2id(String kindId);
}
