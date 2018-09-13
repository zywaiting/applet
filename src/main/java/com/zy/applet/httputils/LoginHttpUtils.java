package com.zy.applet.httputils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zy.applet.pojo.KeyValue;
import com.zy.applet.utils.HttpUtils;
import com.zy.applet.utils.Utils;

//https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code

/**
 * 微信登录功能
 */
public class LoginHttpUtils {
    public static Result loginHttpUtils(String code, String appId, String appSecret, String url) {
        KeyValue[] keyValues = new KeyValue[]{
          new KeyValue("appid",appId),      
          new KeyValue("secret",appSecret),      
          new KeyValue("js_code",code),      
          new KeyValue("grant_type","authorization_code")
        };
        String resultStr = HttpUtils.get(url, keyValues);
        Result result = Utils.json(resultStr, Result.class);
        return result;
    }


    /**
     * //满足UnionID返回条件时，返回的JSON数据包
     * {
     *     "openid": "OPENID",
     *     "session_key": "SESSIONKEY",
     *     "unionid": "UNIONID"
     * }
     * //错误时返回JSON数据包(示例为Code无效)
     * {
     * 	"errcode": 40029,
     * 	"errmsg": "invalid code"
     * }
     */
    public static class Result{
        private String openid;
        @JsonProperty(value = "session_key")
        private String sessionKey;
        private String unionid;
        private String errcode;
        private String errmsg;

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getSessionKey() {
            return sessionKey;
        }

        public void setSessionKey(String sessionKey) {
            this.sessionKey = sessionKey;
        }

        public String getUnionid() {
            return unionid;
        }

        public void setUnionid(String unionid) {
            this.unionid = unionid;
        }

        public String getErrcode() {
            return errcode;
        }

        public void setErrcode(String errcode) {
            this.errcode = errcode;
        }

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }
    }
}
