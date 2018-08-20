package com.zy.applet.pojo;
//微信小程序模板消息
public class WxAppletTemolateMessage {
    /**
     * touser	是	接收者（用户）的 openid
     * template_id	是	所需下发的模板消息的id
     * page	否	点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转。
     * form_id	是	表单提交场景下，为 submit 事件带上的 formId；支付场景下，为本次支付的 prepay_id
     * data	是	模板内容，不填则下发空模板
     * color	否	模板内容字体的颜色，不填默认黑色 【废弃】
     * emphasis_keyword	否	模板需要放大的关键词，不填则默认无放大
     */
    private String touser;
    private String templateId;
    private String page;
    private String formId;
    private Data Data;

    public static class Data{

    }
}
