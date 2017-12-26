package com.demo.controller;

import com.demo.service.IUserService;
import com.utils.JsonUtil;
import com.utils.Msg;
import com.utils.SetSqlId;
import com.utils.TypeIsNull;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


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
            logger.error("=====selectTest=====" + e);
        }
        logger.error("=====selectTest=====" + JsonUtil.toJson(msg));
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
            logger.error("=====example=====" + e);
        }
        logger.error("=====example=====" + JsonUtil.toJson(msg));
        this.send(response,msg);
    }
    
    
    @RequestMapping("/insertUserId")
    public void insertUserId(HttpServletResponse response){
    	Msg msg;
        try {
            msg=this.userService.insertUserId(SetSqlId.GetUuid());
        }catch (Exception e){
            msg = new Msg(Msg.FAIL,Msg.FAIL_MSG);
            logger.error("=====insertUserId=====" + e);
        }
        logger.error("=====insertUserId=====" + JsonUtil.toJson(msg));
        this.send(response,msg);
    }
}
