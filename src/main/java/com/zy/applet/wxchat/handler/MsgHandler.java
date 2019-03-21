package com.zy.applet.wxchat.handler;

import com.zy.applet.service.RealTimeBusService;
import com.zy.applet.wxchat.builder.TextBuilder;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
