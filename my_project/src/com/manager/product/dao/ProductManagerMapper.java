package com.manager.product.dao;

import java.util.List;
import java.util.Map;

import com.manager.product.po.Product;
import com.manager.product.po.Property;

public interface ProductManagerMapper {
	
	/**
	 * <p>Title: insertProduct_1</p>
	 * <p>Description:商品表dao </p>
	 * @param product
	 * @return
	 */
	int insertProduct_1(Product product);
	
	/**
	 * <p>Title: insertProduct_2</p>
	 * <p>Description:商品属性表dao </p>
	 * @param property
	 * @return
	 */
	int insertProduct_2(Property property);
	
	/**
	 * <p>Title: selectProductInfo_paging</p>
	 * <p>Description: 商品列表_分页</p>
	 * @param productName
	 * @return
	 */
	List<Map<String, Object>> selectProductInfo_paging(Map<String, Object> map);
}
