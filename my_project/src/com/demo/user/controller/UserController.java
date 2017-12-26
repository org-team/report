package com.demo.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.common.controller.BaseController;
import com.demo.user.service.IUserService;
import com.utils.JsonUtil;
import com.utils.Msg;
import com.utils.SetSqlId;
import com.utils.TypeIsNull;


/**
 * @author: zhangKangChuang
 * package: com.demo.controller
 * class_name: UserController
 * describe: 测试代码 url: /zkc/test.action
 * email: 996789881@qq.com
 * @data: 2017/12/26 0026 上午 11:02
 **/
@Controller
@RequestMapping("/zkc")
public class UserController extends BaseController {
    private static Logger logger = Logger.getLogger(UserController.class);
    @Resource
    private IUserService userService;

    @RequestMapping("/selectTest")
    public void selectTest(HttpServletResponse response) {
        Msg msg;
        try {
            msg = this.userService.queryUserId();
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("类-selectTest报错-: " + e);
        }
        logger.error("类-selectTest-返回-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
    }


    @RequestMapping("/example")
    public void example(String name,Integer age,HttpServletResponse response) {
        Msg msg;
        try {
            //null==name || "".equals(name) || null==age || "".equals(age)
            if(!TypeIsNull.typeIsNull(name,age)){
                //参数异常
                msg=new Msg(Msg.ERROR,Msg.ERROR_MSG);
            }else{
                msg = this.userService.queryUserId();
            }
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("类-example报错-: " + e);
        }
        logger.error("类-example-返回-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
    }
    
    
    @RequestMapping("/insertUserId")
    public void insertUserId(HttpServletResponse response){
    	Msg msg;
        try {
            msg=this.userService.insertUserId(SetSqlId.GetUuid());
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("类-insertUserId-报错: " + e);
        }
        logger.error("类-insertUserId-返回-: " + JsonUtil.toJson(msg));
        this.send(response,msg);
    }
}
