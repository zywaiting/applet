package com.zy.applet.httputils;

import com.zy.applet.pojo.KeyValue;
import com.zy.applet.utils.HttpUtils;

//https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code

/**
 * 微信登录功能
 */
public class LoginHttpUtils {
    public static KeyValue loginHttpUtils(String code, String appId, String appSecret, String url) {
        KeyValue keyValue = new KeyValue();
        KeyValue[] keyValues = new KeyValue[]{
          new KeyValue("appid",appId),      
          new KeyValue("secret",appSecret),      
          new KeyValue("js_code",code),      
          new KeyValue("grant_type","authorization_code")
        };
        String result = HttpUtils.get(url, keyValues);
        System.out.println(result);
        return keyValue;
    }
}
