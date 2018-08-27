package com.zy.applet.utils.baiduUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zy.applet.pojo.AppletConfig;
import com.zy.applet.pojo.KeyValue;
import com.zy.applet.utils.HttpUtils;
import com.zy.applet.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 获取百度应用的token
 */
public class GetTokenUtils {
    private final static Logger logger = LoggerFactory.getLogger(GetTokenUtils.class);
    private static final String URL = "https://openapi.baidu.com/oauth/2.0/token";

    public static Result getToken(AppletConfig appletConfig){
        Result result = null;
        KeyValue[] keyValues = new KeyValue[]{
                new KeyValue("grant_type","client_credentials"),
                new KeyValue("client_id",appletConfig.getApiKey()),
                new KeyValue("client_secret",appletConfig.getAppSecret())
        };
        String post = HttpUtils.post(URL, keyValues);
        if (StringUtils.isNotBlank(post)){
            result = Utils.json(post, Result.class);
        }else {
            logger.info("百度语音api未查询到数据!");
        }
        return result;
    }

    public static class Result{
        @JsonProperty(value = "access_token")
        private String accessToken;
        @JsonProperty(value = "expires_in")
        private String expiresIn;
        @JsonProperty(value = "refresh_token")
        private String refreshToken;
        @JsonProperty(value = "scope")
        private String scope;
        @JsonProperty(value = "session_key")
        private String sessionKey;
        @JsonProperty(value = "session_secret")
        private String sessionSecret;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(String expiresIn) {
            this.expiresIn = expiresIn;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getSessionKey() {
            return sessionKey;
        }

        public void setSessionKey(String sessionKey) {
            this.sessionKey = sessionKey;
        }

        public String getSessionSecret() {
            return sessionSecret;
        }

        public void setSessionSecret(String sessionSecret) {
            this.sessionSecret = sessionSecret;
        }
    }
}
