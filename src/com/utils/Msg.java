package com.utils;

/**
 * @author: zhangKangChuang
 * package: com.utils
 * class_name: Msg
 * describe: 用于与前端信息交互的对象
 * email: 996789881@qq.com
 * @data: 2017/12/26 0026 上午 10:23
 **/
public class Msg {
	/**
	 * 成功
	 */
	public static final int SUCCESS = 1;
	public static final String SUCCESS_MSG = "请求成功";
	public static final String SUCCESS_INSERT_MSG = "插入成功";
	public static final String SUCCESS_UPDATE_MSG = "更新成功";

	/**
	 * 查询无结果
	 */
	public static final int NULL = 0;
	public static final String NULL_MSG = "查询无结果";

	/**
	 * 请求失败
	 */
	public static final int FAIL = -1;
	public static final String FAIL_MSG = "请求失败";
	public static final String FAIL_INSERT_MSG = "插入失败";
	public static final String FAIL_UPDATE_MSG = "更新失败";

	/**
	 * 参数异常
	 */
	public static final int ERROR = -2;
	public static final String ERROR_MSG = "参数异常";

	/**
	 * 请先登录 (某些业务需要登录权限 )
	 */
	public static final int NOLOGIN = -3;
	public static final String NOLOGIN_MSG = "请登录";


	public Msg(){
		super();
	}

	/**
	 * 适用场景 1,查询成功无数据返回 2,增加,删除,更新成功
	 * @param code
	 * @param message
	 */
	public Msg(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	/**
	 * 适用场景 查询成功并且有数据返回
	 * @param code
	 * @param message
	 * @param data
	 */
	public Msg(int code,String message, Object data) {
		super();
		this.code = code;
		this.data = data;
		this.message=message;
	}




	private int code;
	private Object data;
	private String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void getData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

	
}
