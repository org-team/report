package com.manager.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manager.user.dao.ProductManagerMapper;
import com.manager.user.po.Product;
import com.manager.user.po.Property;
import com.manager.user.service.ProductManagerService;
import com.utils.Msg;


/**
 * <p>Description:商品管理模块 </p>
 * <p>Title: ProductManagerServiceImpl.java</p>
 * @date 2018年1月29日
 */
@Service("productManagerService")
public class ProductManagerServiceImpl implements ProductManagerService {

	@Resource
	private ProductManagerMapper productManagerMapper;
	@Override
	public Msg insertProduct(Product product, Property property) {
		Msg msg;
		this.productManagerMapper.insertProduct_1(product);
		this.productManagerMapper.insertProduct_2(property);
		msg=new Msg(Msg.SUCCESS,Msg.SUCCESS_INSERT_MSG);
		return msg;
		
	}
	
	
}
