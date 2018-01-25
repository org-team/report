package com.manager.user.po;

import java.util.Date;

import com.utils.BaseModel;

/**
 * 
 * <p>Description:用户表,用户详情表,权限表实体类 </p>
 * <p>Title: UserDetail.java</p>
 * @date 2018年1月17日
 */
public class UserDetail extends BaseModel {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户的唯一标识(uuid中的“-”被“”代替)
	 */
	private String userId;

	/**
	 * 用户名(手机、邮箱什么的用户注册信息，不可修改)
	 */
	private String userName;

	/**
	 * 密码(采用MD5进行加密)
	 */
	private String password;

	/**
	 * 登录类型(手机、邮箱什么的用户注册信息)
	 */
	private Boolean type;

	/**
	 * 是否有效(1标识有效、0表示无效)
	 */
	private Boolean valid;

	/**
	 * 昵称(用户自定义的名称，可以修改)
	 */
	private String nickName;

	/**
	 * 角色标识(uuid中的“-”被“”代替)
	 */
	private String roleId;

	/**
	 * 头像(存储头像上传地址)
	 */
	private String userImg;

	/**
	 * 性别(1男，2女，3其他)
	 */
	private int sex;

	/**
	 * 年龄(大于0岁)
	 */
	private int age;

	/**
	 * 地址(关联地址表中的记录)
	 */
	private String addressId;

	/***
	 * 详细地址
	 */
	private String addressDetail;

	/**
	 * 邮政编码
	 */
	private String postcode;

	/**
	 * 电话
	 */
	private String phone;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 版本号(默认为1 ，该条数据变化一次，verson 加1)
	 */
	private int verson;

	/**
	 * 用户创建时间
	 */
	private Date createTime;

	/**
	 * 用户最后一次修改时间
	 */
	private Date updateTime;
	
	/**
	 * 权限名称
	 */
	private String roleName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getVerson() {
		return verson;
	}

	public void setVerson(int verson) {
		this.verson = verson;
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}