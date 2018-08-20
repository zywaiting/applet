package com.zy.applet.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zy.applet.pojo.WxtemplateMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * 用于微信发送
 */
public class WxSendMessageUtils {

    private final static Logger logger = LoggerFactory.getLogger(WxSendMessageUtils.class);



    public static Result wxSendMessageUtils(WxtemplateMessage tSendWxtemplateMessage, String openId){

        Wx wx = new Wx();
        //用户open_id
        wx.setTouser(openId);
        //模板消息
        wx.setTemplate_id(tSendWxtemplateMessage.getTemplateId());
        //设置跳转路径
        wx.setUrl(tSendWxtemplateMessage.getUrl());
        //设置跳转小程序的路径
        Miniprogram miniprogram = new Miniprogram();
        miniprogram.setAppid(tSendWxtemplateMessage.getMiniprogramAppid());
        miniprogram.setPagepath(tSendWxtemplateMessage.getMiniprogramPagepath());
        wx.setMiniprogram(miniprogram);
        //设置发送信息
        Data data = new Data();
        T first = new T();
        first.setValue(tSendWxtemplateMessage.getDataFirstValue());
        first.setColor(tSendWxtemplateMessage.getDataFirstColor());

        T keyword1 = new T();
        keyword1.setValue(tSendWxtemplateMessage.getDataKeyword1Value());
        keyword1.setColor(tSendWxtemplateMessage.getDataKeyword1Color());

        T keyword2 = new T();
        keyword2.setValue(tSendWxtemplateMessage.getDataKeyword2Value());
        keyword2.setColor(tSendWxtemplateMessage.getDataKeyword2Color());

        T keyword3 = new T();
        keyword3.setValue(tSendWxtemplateMessage.getDataKeyword3Value());
        keyword3.setColor(tSendWxtemplateMessage.getDataKeyword3Color());

        T keyword4 = new T();
        keyword4.setValue(tSendWxtemplateMessage.getDataKeyword4Value());
        keyword4.setColor(tSendWxtemplateMessage.getDataKeyword4Color());

        T keyword5 = new T();
        keyword5.setValue(tSendWxtemplateMessage.getDataKeyword5Value());
        keyword5.setColor(tSendWxtemplateMessage.getDataKeyword5Color());

        T remark = new T();
        remark.setValue(tSendWxtemplateMessage.getDataRemarkValue());
        remark.setColor(tSendWxtemplateMessage.getDataRemarkColor());

        data.put("first",first);
        data.put("keyword1",keyword1);
        data.put("keyword2",keyword2);
        data.put("keyword3",keyword3);
        data.put("keyword4",keyword4);
        data.put("keyword5",keyword5);
        data.put("remark",remark);
        wx.setData(data);
        String url = tSendWxtemplateMessage.getSendUrl() + tSendWxtemplateMessage.getAccessToken();
        String resultStr = HttpUtils.post(url, JSONObject.toJSONString(wx));
        Result result = Utils.json(resultStr, Result.class);
        if (0 == result.getErrcode()) {
            logger.info("发送消息成功！");
            return result;
        }else {
            logger.info("错误代码===========================================：{}",result.getErrcode());
            logger.info("错误信息===========================================：{}",result.getErrmsg());
            logger.info("错误id===========================================：{}",result.getMsgid());
            logger.info("发送消息失败！");
            return result;
        }
    }


    public static class Result{
        private Integer errcode;
        private String errmsg;
        private Long msgid;

        public Integer getErrcode() {
            return errcode;
        }

        public void setErrcode(Integer errcode) {
            this.errcode = errcode;
        }

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }

        public Long getMsgid() {
            return msgid;
        }

        public void setMsgid(Long msgid) {
            this.msgid = msgid;
        }
    }



    public static class TokeResult{

        private String accessToken;
        private Integer expiresIn;

        @JsonProperty("access_token")
        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        @JsonProperty("expires_in")
        public Integer getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(Integer expiresIn) {
            this.expiresIn = expiresIn;
        }
    }

    static class Wx{
        private String touser;
        private String template_id;
        private String url;
        private Miniprogram miniprogram;
        private Data data;

        public String getTouser() {
            return touser;
        }

        public void setTouser(String touser) {
            this.touser = touser;
        }

        public String getTemplate_id() {
            return template_id;
        }

        public void setTemplate_id(String template_id) {
            this.template_id = template_id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Miniprogram getMiniprogram() {
            return miniprogram;
        }

        public void setMiniprogram(Miniprogram miniprogram) {
            this.miniprogram = miniprogram;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }
    }
    static class Miniprogram{
        private String appid;
        private String pagepath;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getPagepath() {
            return pagepath;
        }

        public void setPagepath(String pagepath) {
            this.pagepath = pagepath;
        }
    }
    static class Data extends HashMap {

    }
    static class T{
        private String value;
        private String color;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}
