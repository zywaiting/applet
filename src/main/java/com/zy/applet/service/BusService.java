package com.zy.applet.service;

import com.zy.applet.pojo.BusConfig;

import java.util.List;

public interface BusService {
    //查询车辆信息
    List<BusConfig> selectBusConfigByLikeBusName(String busName,String crity);

    //查询线路信息
    Object findBusWay(String busId,String crity);
}
