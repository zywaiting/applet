package com.zy.applet.service;

/**
 * 用于微信登录
 * zy 2018-8-1
 */
public interface LoginService {
    //用户登录
    void onLogin(String code, String express, String appUrl);
}