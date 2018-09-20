package com.zy.applet.service.impl;

import com.zy.applet.mapper.AppletConfigMapper;
import com.zy.applet.mapper.LoginMapper;
import com.zy.applet.mapper.OrderExpressMapper;
import com.zy.applet.mapper.OrderListMapper;
import com.zy.applet.pojo.AppletConfig;
import com.zy.applet.pojo.ExpressContent;
import com.zy.applet.pojo.Order;
import com.zy.applet.service.OrderExpressService;
import com.zy.applet.utils.Utils;
import com.zy.applet.utils.aliyun.ExpressUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderExpressServiceImpl implements OrderExpressService {

    @Autowired
    private OrderExpressMapper orderExpressMapper;
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public ExpressUtils.Result selectExpressContentByExpressNo(String openid, String expressNo, String orderNumber, String shipName) {
        ExpressContent expressContent = orderExpressMapper.selectExpressContentByExpressNo(openid, expressNo);
        if (expressContent != null) {
            Date updateDate = expressContent.getUpdateDate();
            long time = new Date().getTime() - updateDate.getTime();
            long hour = time / (1000 * 60 * 60);
            if ((expressContent.getStatus() == 0 || expressContent.getStatus() == 1 || expressContent.getStatus() == 2) && hour > 3) {
                AppletConfig appletConfig = loginMapper.selectAppletConfig("aly_express");
                String content = ExpressUtils.expressUtils(appletConfig, expressNo, shipName);
                ExpressUtils.Result result = Utils.json(content, ExpressUtils.Result.class);
                ExpressContent expressContentStr = new ExpressContent();
                expressContentStr.setOpenid(openid);
                expressContentStr.setContent(content);
                expressContentStr.setExpressNo(expressNo);
                expressContentStr.setUpdateDate(new Date());
                expressContentStr.setStatus(result.getState());
                orderExpressMapper.updateExpressContentByExpressNo(expressContentStr);
                return result;
            } else {
                ExpressUtils.Result result = Utils.json(expressContent.getContent(), ExpressUtils.Result.class);
                return result;
            }
        }else {
            AppletConfig appletConfig = loginMapper.selectAppletConfig("aly_express");
            String content = ExpressUtils.expressUtils(appletConfig, expressNo, shipName);
            ExpressUtils.Result result = Utils.json(content, ExpressUtils.Result.class);
            ExpressContent expressContentStr = new ExpressContent();
            expressContentStr.setOpenid(openid);
            expressContentStr.setContent(content);
            expressContentStr.setCreditDate(new Date());
            expressContentStr.setUpdateDate(new Date());
            expressContentStr.setExpressNo(expressNo);
            expressContentStr.setStatus(result.getState());
            orderExpressMapper.insterExpressContent(expressContentStr);

            return result;
        }
    }
}
