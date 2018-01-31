package com.manager.user.service;

import com.manager.user.po.Product;
import com.manager.user.po.Property;
import com.utils.Msg;

public interface ProductManagerService {
	
	/**
	 * <p>Title: insertProduct</p>
	 * <p>Description:添加商品 </p>
	 * @param product
	 * @param property
	 * @return
	 */
	Msg insertProduct(Product product,Property property);
}
