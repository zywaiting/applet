package com.zy.applet;

import com.zy.applet.pojo.TencentBotReturn;
import com.zy.applet.pojo.TencentPictureReturn;
import com.zy.applet.utils.Base64TestUtils;
import com.zy.applet.utils.kedaxunfeiutils.KeDaXuFeiUtils;
import com.zy.applet.utils.tencent.TencentBotUtils;
import com.zy.applet.utils.tencent.TencentPictureUtils;
import com.zy.applet.wechatbot.WeChatBot;
import com.zy.applet.wechatbot.api.annotation.Bind;
import com.zy.applet.wechatbot.api.constant.Config;
import com.zy.applet.wechatbot.api.enums.AccountType;
import com.zy.applet.wechatbot.api.enums.MsgType;
import com.zy.applet.wechatbot.api.model.WeChatMessage;
import com.zy.applet.wechatbot.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloBot extends WeChatBot {


    public HelloBot(Config config) {
        super(config);
    }

    //个人
    @Bind(msgType = MsgType.TEXT, accountType = AccountType.TYPE_FRIEND)
    public void handleText(WeChatMessage message) {
        if (StringUtils.isNotEmpty(message.getName())) {
            log.info("接收到 [{}] 的消息: {}", message.getName(), message.getText());
            if ("开机".equals(message.getText())) {
                this.sendMsg(message.getFromUserName(), "瑶瑶以准备好，要和你大战300个回合![色][色][色]");
                TencentBotReturn tencentBotReturn = TencentBotUtils.tencentBot(message.getText(), message.getFromUserName(), message.getText());
                return;
            } else if ("关机".equals(message.getText())) {
                TencentBotReturn tencentBotReturn = TencentBotUtils.tencentBot(message.getText(), message.getFromUserName(), message.getText());
                this.sendMsg(message.getFromUserName(), "瑶瑶要走了,别想我![可怜][可怜][可怜]");
                return;
            } else {
                TencentBotReturn tencentBotReturn = TencentBotUtils.tencentBot(message.getText(), message.getFromUserName(), message.getText());
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


    //群组
    @Bind(msgType = MsgType.TEXT, accountType = AccountType.TYPE_GROUP)
    public void handleGroupText(WeChatMessage message) {
        if (StringUtils.isNotEmpty(message.getName())) {
            log.info("接收到 [{}] 的消息: {}", message.getName(), message.getText());
            if (message.isAtMe()) {
                TencentBotReturn tencentBotReturn = TencentBotUtils.tencentBot(message.getText(), message.getFromUserName(), message.getText());
                if (tencentBotReturn.getRet() == 0) {
                    this.sendMsg(message.getFromUserName(), tencentBotReturn.getData().getAnswer().replaceAll("豪豪", "瑶瑶"));
                } else {
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

    @Bind(msgType = MsgType.IMAGE)
    public void handleImage(WeChatMessage message) {
        if (StringUtils.isNotEmpty(message.getName())) {
            log.info("接收到 [{}] 的消息: {}", message.getName(), message.getText());
            TencentPictureReturn tencentPictureReturn = TencentPictureUtils.tencentPicture(message.getImagePath(), "5");
            if (!"关机".equals(tencentPictureReturn.getMsg()) && tencentPictureReturn.getRet() == 0 &&
                    tencentPictureReturn.getData().getImage() != null && StringUtils.isNotEmpty(tencentPictureReturn.getData().getImage())) {
                String imageUrl = Base64TestUtils.GenerateImage(tencentPictureReturn.getData().getImage());
                this.sendImg(message.getFromUserName(), imageUrl);
            }
        }
    }
}