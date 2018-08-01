package com.zy.applet.controller;

import com.zy.applet.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信用户登录
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("onLogin")
    public void onLogin(String code, String express, String name) {
        loginService.onLogin(code, express, name);
    }
}
