package com.zy.applet.service.impl;

import com.zy.applet.httputils.LoginHttpUtils;
import com.zy.applet.mapper.LoginMapper;
import com.zy.applet.pojo.AppletConfig;
import com.zy.applet.pojo.AppletUrl;
import com.zy.applet.pojo.UserConfig;
import com.zy.applet.service.AppletUrlService;
import com.zy.applet.service.LoginService;
import com.zy.applet.service.UserConfigService;
import com.zy.applet.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public String onLogin(String code, String express, String name, String userInfo, String location) {
        AppletConfig appletConfig = loginMapper.selectAppletConfig(express);
        AppletUrl appletUrl = appletUrlService.selectAppletUrl(name);
        LoginHttpUtils.Result result = LoginHttpUtils.loginHttpUtils(code, appletConfig.getAppId(), appletConfig.getAppSecret(), appletUrl.getUrl());
        if (result != null && !StringUtils.isEmpty(result.getOpenid())) {
            UserConfig userConfig = new UserConfig();
            if (userInfo != null && StringUtils.isNoneBlank(userInfo)) {
                logger.info("userInfo:{}", location);
                userConfig = Utils.json(userInfo, UserConfig.class);
            }
            if (location == "null" && StringUtils.isNoneBlank(location)) {
                logger.info("location:{}", location);
                userConfig = Utils.json(location, UserConfig.class);
            }
            userConfig.setOpenId(result.getOpenid());
            userConfig.setUnionId(result.getUnionid());
            Integer integer = userConfigService.selectCountUserConfigByOpenId(userConfig.getOpenId());
            if (integer > 0) {
                //补全用户信息
                Integer updateCount = userConfigService.updateUserConfigByOpenId(userConfig);
                logger.info("补全用户信息成功:{}", updateCount);
            } else {
                Integer insterCount = userConfigService.insterUserConfig(userConfig);
                logger.info("新用户登记成功:{}", insterCount);
            }
            return result.getOpenid();
        }
        return "";
    }
    /**
     * latitude	纬度，浮点数，范围为-90~90，负数表示南纬
     * longitude	经度，浮点数，范围为-180~180，负数表示西经
     * speed	速度，浮点数，单位m/s
     * accuracy	位置的精确度
     * altitude	高度，单位 m	1.2.0
     * verticalAccuracy	垂直精度，单位 m（Android 无法获取，返回 0）	1.2.0
     * horizontalAccuracy	水平精度，单位 m	1.2.0
     */

}
