package com.manager.user.po;

import com.utils.BaseModel;

/**
 * <p>Description:商品属性表  t_yc_property</p>
 * <p>Title: Property.java</p>
 * @date 2018年1月29日
 */
public class Property extends BaseModel {

	private static final long serialVersionUID = -6880799364975880534L;
	
	  private int id;

	  /**
	   * 商品唯一标识
	   */
	  private String productId;

	  /**
	   * 商品属性唯一标识
	   */
	  private String propertyId;

	  /**
	   * 商品属性
	   */
	  private String property;

	  /**
	   * 商品型号
	   */
	  private String model;
	  
	  /**
	   * 原价格(未打折之前的)
	   */
	  private Double priceOld;

	 /**
	  * 商品剩余量
	  */
	  private int surplus;

	 /**
	  * 商品总量
	  */
	  private int total;

	  /**
	   * 商品单位
	   */
	  private String unit;

	  /**
	   * 备注
	   */
	  private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getPriceOld() {
		return priceOld;
	}

	public void setPriceOld(Double priceOld) {
		this.priceOld = priceOld;
	}

	public int getSurplus() {
		return surplus;
	}

	public void setSurplus(int surplus) {
		this.surplus = surplus;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	  
	  
	
}
