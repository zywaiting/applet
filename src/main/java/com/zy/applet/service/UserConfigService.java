package com.zy.applet.service;

import com.zy.applet.pojo.UserConfig;

/**
 * 用户信息
 * zy 2018-8-1
 */
public interface UserConfigService {
    //查询是不是已经有用户信息
    Integer selectCountUserConfigByOpenId(String openId);
    //插入用户数据
    Integer insterUserConfig(UserConfig userConfig);
    //补全用户信息
    Integer updateUserConfigByOpenId(UserConfig userConfig);
    //查询用户信息
    UserConfig selectByOpenId(String openId);
}
