package com.zy.applet.service;

import com.zy.applet.pojo.AppletConfig;

public interface AppletConfigService {
    //更新app_secret
    void updateAppSecret();
    //更新百度语音的token
    void updateBaiDuToken();

    //获取信息
    AppletConfig findByExpress(String express);
}
