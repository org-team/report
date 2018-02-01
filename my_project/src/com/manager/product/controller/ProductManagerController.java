package com.manager.product.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manager.common.controller.BaseController;
import com.manager.product.po.Kind;
import com.manager.product.po.Product;
import com.manager.product.po.Property;
import com.manager.product.service.ProductManagerService;
import com.utils.JsonUtil;
import com.utils.Msg;
import com.utils.Page;
import com.utils.SetSqlId;
import com.utils.TypeIsNull;
/**
 * <p>Description:商品管理 </p>
 * <p>Title: ProductManagerController.java</p>
 * @date 2018年1月29日
 */
@Controller
@RequestMapping("/product")
public class ProductManagerController extends BaseController {
	private static Logger logger = Logger.getLogger(ProductManagerController.class);
	@Resource
	private ProductManagerService productManagerService;
	
	/**
	 * <p>Title: addProduct</p>
	 * <p>Description:添加商品 </p>
	 * @param product
	 * @param property
	 * @param response
	 */
	@RequestMapping("/addProduct")
	public void addProduct(Product product, Property property,HttpServletResponse response){
		Msg msg;
        try {
        	if(!TypeIsNull.typeIsNull(product.getProductName(),property.getPriceOld())){
        		//参数异常
                msg=new Msg(Msg.ERROR,Msg.ERROR_MSG);
        	}else{
        		//uuid
        		product.setProductId(SetSqlId.GetUuid());
        		property.setProductId(product.getProductId());
        		property.setPropertyId(SetSqlId.GetUuid());
        		msg=this.productManagerService.insertProduct(product, property);
        	}
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("类-addProduct-报错: " + e);
        }
        logger.error("类-addProduct-返回-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
	}
	
	/**
	 * <p>Title: queryKind</p>
	 * <p>Description:查询所有商品分类</p>
	 * @param response
	 */
	@RequestMapping("/queryKind")
	public void queryKind(Kind k,Page page,HttpServletResponse response){
		Msg msg;
        try {
        	k.setPage(page);
        	msg=this.productManagerService.selectKind__paging(k);
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("类-queryKind-报错: " + e);
        }
        logger.error("类-queryKind-返回-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
	}
	
	/**
	 * <p>Title: insertKind</p>
	 * <p>Description: 插入分类</p>
	 * @param k
	 * @param response
	 */
	@RequestMapping("/addKind")
	public void addKind(Kind k,HttpServletResponse response){
		Msg msg;
        try {
        	if(!TypeIsNull.typeIsNull(k.getKindName())){
        		//参数异常
                msg=new Msg(Msg.ERROR,Msg.ERROR_MSG);
        	}else{
        		k.setKindId(SetSqlId.GetUuid());
            	msg=this.productManagerService.insertKind(k);
        	}
        	
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("类-addKind-报错: " + e);
        }
        logger.info("类-addKind-返回-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
	}


	/**
	 * 删除分类
	 * <p>Title: deleteKindName2id</p>
	 * <p>Description: </p>
	 * @param kindId
	 * @param response
	 */
	@RequestMapping("/deleteKindName2id")
	public void deleteKindName2id(String kindId,HttpServletResponse response){
		Msg msg;
        try {
        	if(!TypeIsNull.typeIsNull(kindId)){
        		//参数异常
                msg=new Msg(Msg.ERROR,Msg.ERROR_MSG);
        	}else{
            	msg=this.productManagerService.deleteKindName2id(kindId);
        	}
        	
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("类-deleteKindName2id-报错: " + e);
        }
        logger.info("类-deleteKindName2id-返回-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
	}
}
