package com.zy.applet;

import com.zy.applet.pojo.TencentBotReturn;
import com.zy.applet.utils.kedaxunfeiutils.KeDaXuFeiUtils;
import com.zy.applet.utils.tencent.TencentBotUtils;
import com.zy.applet.wechatbot.WeChatBot;
import com.zy.applet.wechatbot.api.annotation.Bind;
import com.zy.applet.wechatbot.api.constant.Config;
import com.zy.applet.wechatbot.api.enums.MsgType;
import com.zy.applet.wechatbot.api.model.WeChatMessage;
import com.zy.applet.wechatbot.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloBot extends WeChatBot {


    public HelloBot(Config config) {
        super(config);
    }

    @Bind(msgType = MsgType.TEXT)
    public void handleText(WeChatMessage message) {
        if (StringUtils.isNotEmpty(message.getName())) {
            log.info("接收到 [{}] 的消息: {}", message.getName(), message.getText());
            TencentBotReturn tencentBotReturn = TencentBotUtils.tencentBot(message.getText(),message.getFromUserName(), message.getText());
            if (!"关机".equals(tencentBotReturn.getMsg())) {
                if (tencentBotReturn.getRet() == 0) {
                    this.sendMsg(message.getFromUserName(), tencentBotReturn.getData().getAnswer().replaceAll("豪豪","瑶瑶"));
                }else {
                    this.sendMsg(message.getFromUserName(), "信息量太大，容瑶瑶想想。。。[晕][晕][晕]");
                }

            }
        }
    }

    @Bind(msgType = MsgType.VOICE)
    public void handleVideo(WeChatMessage message) {
        if (StringUtils.isNotEmpty(message.getName())) {
            log.info("接收到 [{}] 的消息: {}", message.getName(), message.getText());
            KeDaXuFeiUtils.Result result = KeDaXuFeiUtils.speechRecognizer(message.getVoicePath());
            if (result != null && "success".equals(result.getDesc())) {
                TencentBotReturn tencentBotReturn = TencentBotUtils.tencentBot(result.getCode(), message.getFromUserName(), result.getData());
                if (!"关机".equals(tencentBotReturn.getMsg())) {
                    if (tencentBotReturn.getRet() == 0) {
                        this.sendMsg(message.getFromUserName(), tencentBotReturn.getData().getAnswer().replaceAll("豪豪", "瑶瑶"));
                    } else {
                        this.sendMsg(message.getFromUserName(), "信息量太大，容瑶瑶想想。。。[晕][晕][晕]");
                    }
                }
            }
        }
    }

}