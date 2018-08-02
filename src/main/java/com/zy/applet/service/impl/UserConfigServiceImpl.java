package com.zy.applet.service.impl;

import com.zy.applet.httputils.LoginHttpUtils;
import com.zy.applet.mapper.LoginMapper;
import com.zy.applet.mapper.UserConfigMapper;
import com.zy.applet.pojo.AppletConfig;
import com.zy.applet.pojo.AppletUrl;
import com.zy.applet.service.AppletUrlService;
import com.zy.applet.service.LoginService;
import com.zy.applet.service.UserConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserConfigServiceImpl implements UserConfigService {

    @Autowired
    private UserConfigMapper userConfigMapper;

    @Override
    public Integer selectCountUserConfigByOpenId(String openId) {
        return userConfigMapper.selectCountUserConfigByOpenId(openId);
    }

    @Override
    public Integer insterUserConfigOfOpenId(String openId, String unionId) {
        return userConfigMapper.insterUserConfigOfOpenId(openId,unionId);
    }
}
