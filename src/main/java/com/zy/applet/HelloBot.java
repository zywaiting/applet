package com.zy.applet;

import com.zy.applet.utils.OlamiUtils;
import io.github.biezhi.wechat.WeChatBot;
import io.github.biezhi.wechat.api.annotation.Bind;
import io.github.biezhi.wechat.api.constant.Config;
import io.github.biezhi.wechat.api.enums.MsgType;
import io.github.biezhi.wechat.api.model.WeChatMessage;
import io.github.biezhi.wechat.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class HelloBot extends WeChatBot {

    public HelloBot(Config config) {
        super(config);
    }

    @Bind(msgType = MsgType.TEXT)
    public void handleText(WeChatMessage message) {
        if (StringUtils.isNotEmpty(message.getName())) {
            log.info("接收到 [{}] 的消息: {}", message.getName(), message.getText());
            OlamiUtils.Result result = OlamiUtils.textRecognizer(message.getText());
            String content = "";
            String ask = "";
            if (Optional.ofNullable(result).map(OlamiUtils.Result::getData)
                    .map(OlamiUtils.Data::getNliList)
                    .map(a -> a.get(0))
                    .map(b -> b.getDescObj()).map(c -> c.getResult()).isPresent()){
                content = result.getData().getNliList().get(0).getDescObj().getResult();
            }
            if (Optional.ofNullable(result).map(OlamiUtils.Result::getData)
                    .map(OlamiUtils.Data::getNliList)
                    .map(a -> a.get(0))
                    .map(b -> b.getDataObjList()).map(c -> c.get(0)).map(d -> d.getContent()).isPresent()) {
                ask = "\n\n\n" + result.getData().getNliList().get(0).getDataObjList().get(0).getContent();
            }
            this.sendMsg(message.getFromUserName(), content + ask);
        }
    }


}