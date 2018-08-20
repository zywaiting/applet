package com.zy.applet.pojo;

/**
 * @zy
 * 微信模板消息
 */
public class WxtemplateMessage {
    /**
     * `id` int(11) NOT NULL COMMENT 'id',
     *   `appid` varchar(255) DEFAULT NULL COMMENT '公众号的appid',
     *   `secret` varchar(255) DEFAULT NULL COMMENT '开发者密码',
     *   `access_token` varchar(255) DEFAULT NULL COMMENT 'access_token',
     *   `template_id` varchar(255) DEFAULT NULL COMMENT '模板id',
     *   `url` varchar(255) DEFAULT NULL COMMENT '跳转路径',
     *   `miniprogram_appid` varchar(255) DEFAULT NULL COMMENT '所需跳转到的小程序appid',
     *   `miniprogram_pagepath` varchar(255) DEFAULT NULL COMMENT '所需跳转到小程序的具体页面路径',
     *   `data_firstValue` varchar(255) DEFAULT NULL COMMENT '数据',
     *   `data_firstColor` varchar(255) DEFAULT NULL COMMENT '字体颜色',
     *   `dataKeyword1Value` varchar(255) DEFAULT NULL,
     *   `dataKeyword1Color` varchar(255) DEFAULT NULL,
     *   `dataKeyword2Value` varchar(255) DEFAULT NULL,
     *   `dataKeyword2Color` varchar(255) DEFAULT NULL,
     *   `dataKeyword3Value` varchar(255) DEFAULT NULL,
     *   `dataKeyword3Color` varchar(255) DEFAULT NULL,
     *   `dataKeyword4Value` varchar(255) DEFAULT NULL,
     *   `dataKeyword4Color` varchar(255) DEFAULT NULL,
     *   `dataKeyword5Value` varchar(255) DEFAULT NULL,
     *   `dataKeyword5Color` varchar(255) DEFAULT NULL,
     *   `data_remarkValue` varchar(255) DEFAULT NULL,
     *   `data_remarkColor` varchar(255) DEFAULT NULL,
     *   `remark` varchar(255) DEFAULT NULL COMMENT '注释',
     */
    private Integer id;
    private String appid;
    private String secret;
    private String accessToken;
    private String templateId;
    private String url;
    private String miniprogramAppid;
    private String miniprogramPagepath;
    private String dataFirstValue;
    private String dataFirstColor;
    private String dataKeyword1Value;
    private String dataKeyword1Color;
    private String dataKeyword2Value;
    private String dataKeyword2Color;
    private String dataKeyword3Value;
    private String dataKeyword3Color;
    private String dataKeyword4Value;
    private String dataKeyword4Color;
    private String dataKeyword5Value;
    private String dataKeyword5Color;
    private String dataRemarkValue;
    private String dataRemarkColor;
    private String sendUrl;
    private String remark;

    public String getSendUrl() {
        return sendUrl;
    }

    public void setSendUrl(String sendUrl) {
        this.sendUrl = sendUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMiniprogramAppid() {
        return miniprogramAppid;
    }

    public void setMiniprogramAppid(String miniprogramAppid) {
        this.miniprogramAppid = miniprogramAppid;
    }

    public String getMiniprogramPagepath() {
        return miniprogramPagepath;
    }

    public void setMiniprogramPagepath(String miniprogramPagepath) {
        this.miniprogramPagepath = miniprogramPagepath;
    }

    public String getDataFirstValue() {
        return dataFirstValue;
    }

    public void setDataFirstValue(String dataFirstValue) {
        this.dataFirstValue = dataFirstValue;
    }

    public String getDataFirstColor() {
        return dataFirstColor;
    }

    public void setDataFirstColor(String dataFirstColor) {
        this.dataFirstColor = dataFirstColor;
    }

    public String getDataKeyword1Value() {
        return dataKeyword1Value;
    }

    public void setDataKeyword1Value(String dataKeyword1Value) {
        this.dataKeyword1Value = dataKeyword1Value;
    }

    public String getDataKeyword1Color() {
        return dataKeyword1Color;
    }

    public void setDataKeyword1Color(String dataKeyword1Color) {
        this.dataKeyword1Color = dataKeyword1Color;
    }

    public String getDataKeyword2Value() {
        return dataKeyword2Value;
    }

    public void setDataKeyword2Value(String dataKeyword2Value) {
        this.dataKeyword2Value = dataKeyword2Value;
    }

    public String getDataKeyword2Color() {
        return dataKeyword2Color;
    }

    public void setDataKeyword2Color(String dataKeyword2Color) {
        this.dataKeyword2Color = dataKeyword2Color;
    }

    public String getDataKeyword3Value() {
        return dataKeyword3Value;
    }

    public void setDataKeyword3Value(String dataKeyword3Value) {
        this.dataKeyword3Value = dataKeyword3Value;
    }

    public String getDataKeyword3Color() {
        return dataKeyword3Color;
    }

    public void setDataKeyword3Color(String dataKeyword3Color) {
        this.dataKeyword3Color = dataKeyword3Color;
    }

    public String getDataKeyword4Value() {
        return dataKeyword4Value;
    }

    public void setDataKeyword4Value(String dataKeyword4Value) {
        this.dataKeyword4Value = dataKeyword4Value;
    }

    public String getDataKeyword4Color() {
        return dataKeyword4Color;
    }

    public void setDataKeyword4Color(String dataKeyword4Color) {
        this.dataKeyword4Color = dataKeyword4Color;
    }

    public String getDataKeyword5Value() {
        return dataKeyword5Value;
    }

    public void setDataKeyword5Value(String dataKeyword5Value) {
        this.dataKeyword5Value = dataKeyword5Value;
    }

    public String getDataKeyword5Color() {
        return dataKeyword5Color;
    }

    public void setDataKeyword5Color(String dataKeyword5Color) {
        this.dataKeyword5Color = dataKeyword5Color;
    }

    public String getDataRemarkValue() {
        return dataRemarkValue;
    }

    public void setDataRemarkValue(String dataRemarkValue) {
        this.dataRemarkValue = dataRemarkValue;
    }

    public String getDataRemarkColor() {
        return dataRemarkColor;
    }

    public void setDataRemarkColor(String dataRemarkColor) {
        this.dataRemarkColor = dataRemarkColor;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
