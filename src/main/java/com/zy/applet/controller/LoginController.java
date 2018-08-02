package com.zy.applet.controller;

import com.zy.applet.service.LoginService;
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

    //用户登录接口
    @RequestMapping("onLogin")
    public void onLogin(String code, String express, String name) {
        logger.info("调用了用户登录接口---------------onLogin");
        loginService.onLogin(code, express, name);
    }
}
