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
public class WxAppletSendMessageUtils {

    private final static Logger logger = LoggerFactory.getLogger(WxAppletSendMessageUtils.class);



    public static Result wxAppletSendMessageUtils(String template_id,String page,String form_id, String openId){

        Wx wx = new Wx();
        //用户open_id
        wx.setTouser(openId);
        //模板消息
        wx.setTemplate_id(template_id);
        wx.setForm_id(form_id);
        //设置跳转路径
        wx.setPage(page);
        //设置发送信息
        Data data = new Data();


        T keyword1 = new T();
        keyword1.setValue("齐伟豪,你怎么不生成名片看看呢!");

        T keyword2 = new T();
        keyword2.setValue("测试看看,点我的!");

        data.put("keyword1",keyword1);
        data.put("keyword2",keyword2);
        wx.setData(data);
        String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=13_w-xIY2xZ497qe-7iQHB8arFrBXxqLPOelCqWL3EhGdOLjIzzKminYtQNnYlz-ywBxp6UUip4Zd2ybQHgUB58_dqgWlZnjOWX-cOMxmBgV95cjGmmPGJSKd--1axCN8VIDOrc1VcjlJju8ohRGMMbADARXX";
        String resultStr = HttpUtils.post(url, JSONObject.toJSONString(wx));
        Result result = Utils.json(resultStr, Result.class);
        if (0 == result.getErrcode()) {
            logger.info("发送消息成功！");
            return result;
        }else {
            logger.info("错误代码===========================================：{}",result.getErrcode());
            logger.info("错误信息===========================================：{}",result.getErrmsg());
            logger.info("发送消息失败！");
            return result;
        }
    }


    public static void main(String[] args) {
        Result result = wxAppletSendMessageUtils("e28DKDZV1TzLKX7Onqf9A5n-p-o7pYCRjDgTYxS31KM", "pages/specialty/specialty", "ff9178af0f18e323bf2beea8c31936b4", "oN0r64lLw7elZnGvq6cIbYcg7h8M");
        System.out.println(result.errcode);
    }

    /**
     * {
     *   "errcode": 0,
     *   "errmsg": "ok"
     * }
     */

    public static class Result{
        private Integer errcode;
        private String errmsg;

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
    }

    /**
     * {
     *   "touser": "OPENID",
     *   "template_id": "TEMPLATE_ID",
     *   "page": "index",
     *   "form_id": "FORMID",
     *   "data": {
     *       "keyword1": {
     *           "value": "339208499"
     *       },
     *       "keyword2": {
     *           "value": "2015年01月05日 12:30"
     *       },
     *       "keyword3": {
     *           "value": "粤海喜来登酒店"
     *       } ,
     *       "keyword4": {
     *           "value": "广州市天河区天河路208号"
     *       }
     *   },
     *   "emphasis_keyword": "keyword1.DATA"
     * }
     */

    static class Wx{
        private String touser;
        private String template_id;
        private String page;
        private String form_id;
        private Data data;
        private String emphasis_keyword;

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

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getForm_id() {
            return form_id;
        }

        public void setForm_id(String form_id) {
            this.form_id = form_id;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public String getEmphasis_keyword() {
            return emphasis_keyword;
        }

        public void setEmphasis_keyword(String emphasis_keyword) {
            this.emphasis_keyword = emphasis_keyword;
        }
    }

    static class Data extends HashMap {

    }

    static class T{
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }
}
