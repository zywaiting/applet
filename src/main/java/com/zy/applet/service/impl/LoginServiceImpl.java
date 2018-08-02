package com.zy.applet.service.impl;

import com.zy.applet.httputils.LoginHttpUtils;
import com.zy.applet.mapper.LoginMapper;
import com.zy.applet.pojo.AppletConfig;
import com.zy.applet.pojo.AppletUrl;
import com.zy.applet.service.AppletUrlService;
import com.zy.applet.service.LoginService;
import com.zy.applet.service.UserConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class LoginServiceImpl implements LoginService {

    private final static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private AppletUrlService appletUrlService;
    @Autowired
    private UserConfigService userConfigService;
    //实现用户登录
    @Override
    public void onLogin(String code, String express, String name) {
        AppletConfig appletConfig = loginMapper.selectAppletConfig(express);
        AppletUrl appletUrl = appletUrlService.selectAppletUrl(name);
        LoginHttpUtils.Result result = LoginHttpUtils.loginHttpUtils(code, appletConfig.getAppId(), appletConfig.getAppSecret(), appletUrl.getUrl());
        if (result != null && !StringUtils.isEmpty(result.getOpenid())) {
            Integer integer = userConfigService.selectCountUserConfigByOpenId(result.getOpenid());
            if (integer > 0) {
                return;
            }else {
                Integer count = userConfigService.insterUserConfigOfOpenId(result.getOpenid(), result.getUnionid());
                logger.info("新用户登记成功:{}",count);
            }
        }
    }
}
