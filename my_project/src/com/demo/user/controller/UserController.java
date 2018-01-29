package com.demo.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.common.controller.BaseController;
import com.demo.user.po.User;
import com.demo.user.service.IUserService;
import com.utils.JsonUtil;
import com.utils.Msg;
import com.utils.TypeIsNull;


/**
 * 该控制层用于处理用户相关部分信息
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    
	private Logger logger = Logger.getLogger(UserController.class);
    
    @Resource
    private IUserService userService;

    /**
     * 用户信息注册
     * @param u
     * @param response
     */
    @RequestMapping(value="/regist", method=RequestMethod.POST)
    @ResponseBody
    public void regist(User user,HttpServletResponse response) {
        Msg msg;
        try {
        	logger.info("注册用户请求参数: " + user.toString());
        	//判断参数是不是为空
        	if(TypeIsNull.typeIsNull(user)){
        		msg = this.userService.registUser(user);
            }else{
                //参数异常
                msg=new Msg(Msg.ERROR,Msg.ERROR_MSG);
            }
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("注册用户出错。。。" + e);
        }
        logger.info("用户注册返回结果-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
    }

    /**
     * 用户登录
     * @param user_name
     * @param password
     * @param response
     */
    @RequestMapping(value="/login", produces = "text/plain;charset=utf-8", method=RequestMethod.POST)
    @ResponseBody
    public void login(String user_name, String password ,HttpServletResponse response){
    	 Msg msg;
         try {
         	logger.info("用户登录请求参数: " + user_name + "---" + password);
         	//判断参数是不是为空
         	if(TypeIsNull.typeIsNull(user_name,password)){
         		msg = this.userService.loginUser(user_name, password);
            }else{
                //参数异常
                msg=new Msg(Msg.ERROR,Msg.ERROR_MSG);
            }
         }catch(Exception e){
        	 msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
             logger.error("登录出错。。。" + e);
         }
         logger.info("用户登录返回结果-: " + JsonUtil.toJson(msg));
         this.send(response,msg);
    }
    
    /**
     * 密码修改
     * @param user_name
     * @param old_password
     * @param new_password
     * @param response
     */
    @RequestMapping(value="/upd_password", produces = "text/plain;charset=utf-8", method=RequestMethod.POST)
    @ResponseBody
    public void upd_password(String user_name, String old_password ,String new_password ,HttpServletResponse response){
    	Msg msg;
        try {
        	logger.info("修改密码请求参数: " + user_name + "---" + old_password + "---" + new_password);
        	//判断参数是不是为空
        	if(TypeIsNull.typeIsNull(user_name,old_password,new_password)){
        		msg = this.userService.changePassword(user_name, old_password, new_password);
           }else{
               //参数异常
               msg=new Msg(Msg.ERROR,Msg.ERROR_MSG);
           }
        }catch(Exception e){
       	 	msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("修改密码出错。。。" + e);
        }
        logger.info("修改密码返回结果-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
    }
    
    /**
     * 查询用户详细信息
     * @param user_id
     * @param response
     */
    @RequestMapping(value="/sel_profile", produces = "text/plain;charset=utf-8", method=RequestMethod.POST)
    @ResponseBody
    public void sel_profile(String user_id ,HttpServletResponse response){
    	Msg msg;
        try {
        	logger.info("查询用户详细信息请求参数: " + user_id);
        	//判断参数是不是为空
        	if(TypeIsNull.typeIsNull(user_id)){
        		msg = this.userService.getUserDetail(user_id);
           }else{
               //参数异常
               msg=new Msg(Msg.ERROR,Msg.ERROR_MSG);
           }
        }catch(Exception e){
       	 	msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("查询用户详细信息出错。。。" + e);
        }
        logger.info("查询用户详细信息返回结果-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
    }
    
    /**
     * 修改用户信息
     * @param user
     * @param response
     */
    @RequestMapping(value="/upd_profile", produces = "text/plain;charset=utf-8", method=RequestMethod.POST)
    @ResponseBody
    public void upd_profile(User user ,HttpServletResponse response){
    	Msg msg;
        try {
        	logger.info("修改用户信息请求参数: " + user.toString());
        	//判断参数是不是为空
        	if(TypeIsNull.typeIsNull(user)){
        		msg = this.userService.changeUserDetail(user);
           }else{
               //参数异常
               msg=new Msg(Msg.ERROR,Msg.ERROR_MSG);
           }
        }catch(Exception e){
       	 	msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("修改用户信息出错。。。" + e);
        }
        logger.info("修改用户信息返回结果-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
    }
    
}
