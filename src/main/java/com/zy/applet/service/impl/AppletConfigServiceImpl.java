package com.zy.applet.service.impl;

import com.zy.applet.httputils.AccessToken;
import com.zy.applet.mapper.AppletConfigMapper;
import com.zy.applet.mapper.LoginMapper;
import com.zy.applet.pojo.AppletConfig;
import com.zy.applet.service.AppletConfigService;
import com.zy.applet.utils.baiduUtils.GetTokenUtils;
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
        appletConfigMapper.updateAccessToken(result.getAccessToken(),appletConfig.getAppId());
    }

    @Override
    public void updateBaiDuToken() {
        AppletConfig appletConfig = loginMapper.selectAppletConfig("baudu_token");
        GetTokenUtils.Result result = GetTokenUtils.getToken(appletConfig);
        appletConfigMapper.updateAccessToken(result.getAccessToken(),appletConfig.getAppId());
    }
}
