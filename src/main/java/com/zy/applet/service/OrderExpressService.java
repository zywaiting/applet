package com.zy.applet.service;

import com.zy.applet.utils.aliyun.ExpressUtils;

public interface OrderExpressService {
    //查询快递记录
    ExpressUtils.Result selectExpressContentByExpressNo(String opneid, String expressNo, String orderNumber, String shipName);
}
