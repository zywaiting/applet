package com.zy.applet.controller;

import com.zy.applet.pojo.UserConfig;
import com.zy.applet.service.LoginService;
import com.zy.applet.utils.ResponseMessageUtils;
import com.zy.applet.utils.Utils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信用户登录
 */
@RestController
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    //用户登录接口location
    @RequestMapping("onLogin")
    public ResponseMessageUtils onLogin(String code, String express, String name, String userInfo, String location) {
        logger.info("调用了用户登录接口---------------onLogin");
        String openId = loginService.onLogin(code, express, name, userInfo, location);
        return ResponseMessageUtils.ok(openId);
    }



    //所用小程序用户登录接口
    @RequestMapping("onLoginAll")
    public ResponseMessageUtils onLoginAll(String code, String express, String name, String userInfo) {
        logger.info("调用了用户登录接口---------------onLogin");
        String openId = loginService.onLoginAll(code, express, name, userInfo);
        return ResponseMessageUtils.ok(openId);
    }
}
