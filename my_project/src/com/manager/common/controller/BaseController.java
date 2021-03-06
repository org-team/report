package com.manager.common.controller;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.user.po.User;


import com.alibaba.fastjson.JSON;

/**
 * @author: zhangKangChuang
 * package: com.demo.common.controller
 * class_name: BaseController
 * describe: <p>每个controller都应该继承baseController,减少代码复杂度 ,
 * 在开发过程中依据业务指向待完善</p>
 * email: 996789881@qq.com
 * @data: 2017年12月26日 下午10:12:03
 */
public abstract class BaseController {

	/**
	 * 返回前端登录用户对象，返回null表示该用户没有登录
	 * @param request
	 * @return
	 */
	protected User getUser(HttpServletRequest request){
		User u = null;
		try {
			u = (User)request.getSession().getAttribute("user");
		} catch (Exception e) {
			e.getMessage();
		}
		return u;
	}

	
	/**
	 * 设置session
	 * @Title: setManagerId  
	 * @param request
	 * @param managerId void
	 * @throws
	 */
	protected String setManagerId(HttpServletRequest request ,String managerId){
		String miManagerId = null;
		try {
			HttpSession session = request.getSession();
			//miManagerId = MathUtil.encryptAsString(managerId,"jzcxxt@74521");
			session.setAttribute("managerId",miManagerId);
			System.out.println("setManagerId" + session.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return miManagerId;
	}
	
	/**
	 * 获取登陆用户的IP地址
	 * @param request
	 * @return ip
	 */
	protected String getIp(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 向前端输出对象的json字符串格式
	 * @param response
	 * @param obj
	 */
	protected void send(HttpServletResponse response, Object obj){
		this.send(response, JSON.toJSONString(obj));
	}
	
	/**
	 * 向前端输出字符串
	 * @param str
	 */
	protected void send(HttpServletResponse response, String str){
		PrintWriter pw = null;
		try {
			response.setContentType("text/html;charset=UTF-8"); 
			pw = response.getWriter();
			pw.write(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pw!=null){
				pw.close();
			}
		}
	}
	
}
