package com.zy.applet.wxchat.handler;

import com.zy.applet.entitydto.BaiDuYunDto;
import com.zy.applet.entitydto.TencentBotDto;
import com.zy.applet.service.RealTimeBusService;
import com.zy.applet.utils.baiduUtils.BaiDuYunUtils;
import com.zy.applet.utils.tencent.TencentBotUtils;
import com.zy.applet.wxchat.builder.TextBuilder;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MsgHandler extends AbstractHandler {

    @Autowired
    private RealTimeBusService realTimeBusService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        if (!wxMessage.getMsgType().equals(XmlMsgType.EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        if (wxMessage.getMsgType().equals(XmlMsgType.TEXT)) {
            List<BaiDuYunDto> baiDuYunDtoList = BaiDuYunUtils.selectBaiDuYun(wxMessage.getContent());
            if (baiDuYunDtoList.size() > 0 && wxMessage.getContent().length() > 2) {
                if (baiDuYunDtoList.size() == 1) {
                    String messageAll = "百度网盘地址：" + baiDuYunDtoList.get(0).getAddressUrl() + "\r\n" +
                            "提取码：" + baiDuYunDtoList.get(0).getExtractPower();
                    return new TextBuilder().build(messageAll, wxMessage, weixinService);
                } else if (baiDuYunDtoList.size() > 20) {
                    return new TextBuilder().build("请你说详细点，瑶瑶搜到好多！", wxMessage, weixinService);
                } else {
                    String messageAll = "";
                    for (BaiDuYunDto baiDuYunDto : baiDuYunDtoList) {
                        messageAll = messageAll + "\r\n" + baiDuYunDto.getFileName();
                    }
                    messageAll = messageAll + "\r\n" + "请说具体哪一个，尽量发送完全比配！";
                    return new TextBuilder().build(messageAll, wxMessage, weixinService);
                }
            } else {
                TencentBotDto tencentBotDto = TencentBotUtils.tencentBot(wxMessage.getFromUser(), wxMessage.getContent());
                return new TextBuilder().build(tencentBotDto.getData().getAnswer().replaceAll("豪豪", "瑶瑶"), wxMessage, weixinService);
            }
        }

        //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
//        try {
//            if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
//                && weixinService.getKefuService().kfOnlineList()
//                .getKfOnlineList().size() > 0) {
//                return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE()
//                    .fromUser(wxMessage.getToUser())
//                    .toUser(wxMessage.getFromUser()).build();
//            }
//        } catch (WxErrorException e) {
//            e.printStackTrace();
//        }

        String content = "你好！";

        //TODO 组装回复消息
        logger.info("---------------------------------------{}", wxMessage.getContent());
//        if (StringUtils.endsWith(wxMessage.getContent(), "公交")) {
//            logger.info("调用了realTimeBus接口---------------api/realTimeBus");
//            logger.info("wxMessage.getContent()--------------->{}",wxMessage.getContent());
//            List<BusConfig> busConfig = realTimeBusService.selectBusConfigByCrityAndBusName("苏州", wxMessage.getContent().replaceAll("公交",""));
//            if ("苏州".equals("苏州")) {
//                logger.info("busConfig.getBusId()--------------->{}",busConfig.get(0).getBusId());
//                SouZhouBusUtils.Result result = SouZhouBusUtils.souZhouBusUtils(busConfig.get(0).getBusId());
//                List<SouZhouBusUtils.Data> data = result.getData();
//                SouZhouBusUtils.Result resultNew = new SouZhouBusUtils.Result();
//                List<SouZhouBusUtils.Data> dataNew = new ArrayList<>();
//                for (SouZhouBusUtils.Data datum : data) {
//                    if (StringUtils.isNotBlank(datum.getBusInfo())) {
//                        dataNew.add(datum);
//                    }
//                }
//                resultNew.setData(dataNew);
//                content = JsonUtils.toJson(resultNew);
//            }
//        }else {
//            OlamiUtils.Result result = OlamiUtils.textRecognizer(wxMessage.getContent());
//            content = result.getData().getNliList().get(0).getDescObj().getResult();
//        }


        return new TextBuilder().build(content, wxMessage, weixinService);

    }

}
