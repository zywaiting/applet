package com.zy.applet.service.impl;

import com.zy.applet.httputils.AccessToken;
import com.zy.applet.mapper.AppletConfigMapper;
import com.zy.applet.mapper.LoginMapper;
import com.zy.applet.pojo.AppletConfig;
import com.zy.applet.service.AppletConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppletConfigServiceImpl implements AppletConfigService {

    @Autowired
    private AppletConfigMapper appletConfigMapper;
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public void updateAppSecret() {
        AppletConfig appletConfig = loginMapper.selectAppletConfig("word");
        //https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
        AccessToken.Result result = AccessToken.getAccessToken(appletConfig.getAppId(), appletConfig.getAppSecret());
        appletConfigMapper.insterAccessToken(result.getAccessToken(),appletConfig.getAppId());
    }
}
