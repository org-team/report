package com.manager.product.dao;

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
}
