package com.manager.product.service;



import com.manager.product.po.Kind;
import com.manager.product.po.Product;
import com.manager.product.po.Property;
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
	
	/**
	 * <p>Title: selectKind__paging</p>
	 * <p>Description:查询所有商品分类 </p>
	 * @return
	 */
	Msg selectKind__paging(Kind k);
	
	/**
	 * 添加分类
	 * <p>Title: insertKind</p>
	 * <p>Description: </p>
	 * @param k
	 * @return
	 */
	Msg insertKind(Kind k);
	
	/**
	 * 删除分类
	 * <p>Title: deleteKindName2id</p>
	 * <p>Description: </p>
	 * @param kindId
	 * @return
	 */
	Msg deleteKindName2id(String kindId);
}
