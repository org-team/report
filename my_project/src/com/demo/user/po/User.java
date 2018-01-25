package com.demo.user.po;

import java.util.Date;

/**
 * 用于封装所有关于用户信息的实体类
 * @author Administrator
 *
 */
public class User {

	private static final long serialVersionUID = 1L;
	
	private String user_id;
	// 用于唯一标识
	private String user_name;
	// 用户密码
	private String password;
	// 用户昵称
	private String nick_name;
	// 角色id
	private String role_id;
	// 用户头像
	private String user_img;
	// 性别
	private String sex;
	// 年龄
	private String age;
	// 地址id
	private String address_id;
	// 地址详情
	private String address_detail;
	// 邮政编码
	private String postcode;
	// 电话
	private String phone;
	// 邮箱
	private String email;
	// 备注
	private String remark;
	// 版本号
	private String verson;
	// 创建
	private Date create_time;
	// 最后一次修改时间
	private Date update_time;

	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id.trim();
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password.trim();
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name.trim();
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id.trim();
	}

	public String getUser_img() {
		return user_img;
	}

	public void setUser_img(String user_img) {
		this.user_img = user_img.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex.trim();
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age.trim();
	}

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id.trim();
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail.trim();
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark.trim();
	}

	public String getVerson() {
		return verson;
	}

	public void setVerson(String verson) {
		this.verson = verson.trim();
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", password=" + password + ", nick_name="
				+ nick_name + ", role_id=" + role_id + ", user_img=" + user_img + ", sex=" + sex + ", age=" + age
				+ ", address_id=" + address_id + ", address_detail=" + address_detail + ", postcode=" + postcode
				+ ", phone=" + phone + ", email=" + email + ", remark=" + remark + ", verson=" + verson
				+ ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}

}