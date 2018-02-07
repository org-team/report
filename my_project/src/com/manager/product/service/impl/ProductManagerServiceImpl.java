package com.manager.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manager.product.po.Kind;
import com.manager.product.po.Product;
import com.manager.product.po.Property;
import com.manager.product.dao.KindManagerMapper;
import com.manager.product.dao.ProductManagerMapper;
import com.manager.product.service.ProductManagerService;
import com.utils.Msg;
import com.utils.Page;


/**
 * <p>Description:商品管理模块 </p>
 * <p>Title: ProductManagerServiceImpl.java</p>
 * @date 2018年1月29日
 */
@Service("productManagerService")
public class ProductManagerServiceImpl implements ProductManagerService {

	@Resource
	private ProductManagerMapper productManagerMapper;
	@Resource
	private KindManagerMapper kindManagerMapper;
	@Override
	public Msg insertProduct(Product product, Property property) {
		Msg msg;
		this.productManagerMapper.insertProduct_1(product);
		this.productManagerMapper.insertProduct_2(property);
		msg=new Msg(Msg.SUCCESS,Msg.SUCCESS_INSERT_MSG);
		return msg;
		
	}
	@Override
	public Msg selectKind__paging(Kind k) {
		
		Msg msg;
		List<Map<String,Object>> lst=this.kindManagerMapper.selectKind__paging(k);
        if(null==lst || lst.isEmpty()){
            //查询无结果
            msg=new Msg(Msg.NULL,Msg.NULL_MSG);
        }else{
            Map<String, Object> map=new HashMap<String, Object>();
            
            map.put("lst", lst);
            map.put("page", k.getPage());
            
            msg=new Msg(Msg.SUCCESS,Msg.SUCCESS_MSG,map);
        }
        return msg;
	}
	@Override
	public Msg insertKind(Kind k) {
		Msg msg;
		int numKindNum=this.kindManagerMapper.isExitKindName(k.getKindName());
		if(numKindNum==0){
			this.kindManagerMapper.insertKind(k);
			msg=new Msg(Msg.SUCCESS,Msg.SUCCESS_INSERT_MSG);
		}else{
			msg=new Msg(Msg.FAIL,"分类名称重复");
		}
		return msg;
	}
	@Override
	public Msg deleteKindName2id(String kindId) {
		Msg msg;
		int nRow=this.kindManagerMapper.deleteKindName2id(kindId);
		if(nRow>0){
			msg=new Msg(Msg.SUCCESS,"删除成功");
		}else{
			msg=new Msg(Msg.FAIL,"删除失败");
		}
		return msg;
	}
	@Override
	public Msg selectProductInfo_paging(Map<String, Object> map) {
		Msg msg;
		List<Map<String, Object>> lst=this.productManagerMapper.selectProductInfo_paging(map);
		
		if(null==lst || lst.isEmpty()){
            //查询无结果
            msg=new Msg(Msg.NULL,Msg.NULL_MSG);
        }else{
        	Map<String, Object> map2=new HashMap<>();
        	map2.put("lst", lst);
        	map2.put("page", map.get("page"));
            msg=new Msg(Msg.SUCCESS,Msg.SUCCESS_MSG,map2);
        }
        return msg;
	}
	
	
}
