package com.zy.applet.httputils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zy.applet.pojo.KeyValue;
import com.zy.applet.utils.HttpUtils;
import com.zy.applet.utils.Utils;

/**
 * 获取access_token
 */
public class AccessToken {

    private static final String URL = "https://api.weixin.qq.com/cgi-bin/token";
    public static Result getAccessToken(String appid,String secret){
        KeyValue[] keyValues = new KeyValue[]{
          new KeyValue("grant_type","client_credential"),
          new KeyValue("appid",appid),
          new KeyValue("secret",secret)
        };
        String json = HttpUtils.get(URL, keyValues);
        Result result = Utils.json(json, Result.class);
        return result;
    }

    public static class Result{
        /**
         * {"access_token":"ACCESS_TOKEN","expires_in":7200}
         */
        @JsonProperty(value = "access_token")
        private String accessToken;
        @JsonProperty(value = "expires_in")
        private Integer expiresIn;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public Integer getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(Integer expiresIn) {
            this.expiresIn = expiresIn;
        }
    }
}
