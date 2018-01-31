package com.manager.user.po;

import java.util.Date;

import com.utils.BaseModel;

/**
 * <p>Description:产品表实体 t_yc_product</p>
 * <p>Title: Product.java</p>
 * @date 2018年1月29日
 */
public class Product extends BaseModel {

	
	private static final long serialVersionUID = 4344134795165439745L;

	private int id;

	  /**
	   * 商品唯一标识
	   */
	  private String productId;

	 /**
	  * 商品名称
	  */
	  private String productName;

	  /**
	   * 商品来源(1自营 2联营 3第三方)
	   */
	  private Boolean source;

	  /**
	   * 主图图片（用户列表显示）
	   */
	  private String productImgMain;

	  /**
	   * 详情图片
	   */
	  private String productImgAssist;

	  /**
	   * 商品描述
	   */
	  private String productDescribe;

	  /**
	   * 商品分类id
	   */
	  private String kindId;

	  /**
	   * 商家备注
	   */
	  private String remark;

	  /**
	   * 默认为1 ，该条数据变化一次，verson 加1
	   */
	  private Boolean verson;

	  /**
	   * 1，该条数据有效 2，该条数据无效
	   */
	  private Boolean valid;

	  /**
	   * 创建时间
	   */
	  private Date createTime;

	  /**
	   * 最后修改时间
	   */
	  private Date updateTime;

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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Boolean getSource() {
		return source;
	}

	public void setSource(Boolean source) {
		this.source = source;
	}

	public String getProductImgMain() {
		return productImgMain;
	}

	public void setProductImgMain(String productImgMain) {
		this.productImgMain = productImgMain;
	}

	public String getProductImgAssist() {
		return productImgAssist;
	}

	public void setProductImgAssist(String productImgAssist) {
		this.productImgAssist = productImgAssist;
	}

	public String getProductDescribe() {
		return productDescribe;
	}

	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe;
	}

	public String getKindId() {
		return kindId;
	}

	public void setKindId(String kindId) {
		this.kindId = kindId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Boolean getVerson() {
		return verson;
	}

	public void setVerson(Boolean verson) {
		this.verson = verson;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	  
	  
}
