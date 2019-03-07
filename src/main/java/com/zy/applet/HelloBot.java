package com.zy.applet;

import com.zy.applet.pojo.TencentBotReturn;
import com.zy.applet.utils.tencent.TencentBotUtils;
import io.github.biezhi.wechat.WeChatBot;
import io.github.biezhi.wechat.api.annotation.Bind;
import io.github.biezhi.wechat.api.constant.Config;
import io.github.biezhi.wechat.api.enums.MsgType;
import io.github.biezhi.wechat.api.model.WeChatMessage;
import io.github.biezhi.wechat.utils.StringUtils;
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
            if (!"关机".equals(tencentBotReturn.getMsg()) && tencentBotReturn.getRet() == 0) {
                this.sendMsg(message.getFromUserName(), tencentBotReturn.getData().getAnswer());
            }
        }
    }


}