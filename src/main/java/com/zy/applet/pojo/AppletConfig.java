package com.zy.applet.pojo;

/**
 * zy 2018-8-1
 */
public class AppletConfig {
    /**
     `id` int(11) NOT NULL AUTO_INCREMENT,
     `app_id` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '小程序ID',
     `app_secret` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '小程序密钥',
     `access_token` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT 'token信息',
     `reamke` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
     `express` varchar(255) DEFAULT NULL COMMENT '表示',
     */
    private Integer id;
    private String appId;
    private String appSecret;
    private String accessToken;
    private String reamke;
    private String express;
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getReamke() {
        return reamke;
    }

    public void setReamke(String reamke) {
        this.reamke = reamke;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }
}
