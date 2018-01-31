package com.manager.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manager.common.controller.BaseController;
import com.manager.user.po.Product;
import com.manager.user.po.Property;
import com.manager.user.service.ProductManagerService;
import com.utils.JsonUtil;
import com.utils.Msg;
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
}
