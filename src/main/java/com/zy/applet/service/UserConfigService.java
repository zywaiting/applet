package com.zy.applet.service;

/**
 * 用户信息
 * zy 2018-8-1
 */
public interface UserConfigService {
    //查询是不是已经有用户信息
    Integer selectCountUserConfigByOpenId(String openId);
    //插入用户数据
    Integer insterUserConfigOfOpenId(String openId,String unionId);
}
