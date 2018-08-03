package com.zy.applet.controller;

import me.chanjar.weixin.common.util.crypto.SHA1;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@RestController
public class WxPushMessageController {
    private final static Logger logger = LoggerFactory.getLogger(WxPushMessageController.class);

    private final static String TOKEN = "applet";

    //微信推送消息
    @RequestMapping(method = RequestMethod.GET,value = "wxpushmessage")
    public void git(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
            throw new IllegalArgumentException("请求参数非法，请核实!");
        }

        String[] str = {TOKEN, timestamp, nonce};
        Arrays.sort(str); // 字典序排序
        String bigStr = str[0] + str[1] + str[2];
        // SHA1加密
        SHA1 sha1 = new SHA1();
        String digest = sha1.gen(str);
        // 确认请求来至微信
        if (digest.equals(signature)) {
            response.getWriter().print(echostr);
        }
    }

    @RequestMapping(method = RequestMethod.POST,value = "wxpushmessage")
    public void post(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String string = IOUtils.toString(request.getInputStream(), "UTF-8");
        logger.info("返回数据:{}",string);
    }
}
