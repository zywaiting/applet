package com.zy.applet.service.impl;

import com.zy.applet.httputils.LoginHttpUtils;
import com.zy.applet.mapper.LoginMapper;
import com.zy.applet.pojo.AppletConfig;
import com.zy.applet.pojo.AppletUrl;
import com.zy.applet.service.AppletUrlService;
import com.zy.applet.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private AppletUrlService appletUrlService;
    //实现用户登录
    @Override
    public void onLogin(String code, String express, String name) {
        AppletConfig appletConfig = loginMapper.selectAppletConfig(express);
        AppletUrl appletUrl = appletUrlService.selectAppletUrl(name);
        LoginHttpUtils.loginHttpUtils(code,appletConfig.getAppId(),appletConfig.getAppSecret(),appletUrl.getUrl());
    }
}
