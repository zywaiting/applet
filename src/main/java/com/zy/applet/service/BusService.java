package com.zy.applet.service;

import com.zy.applet.pojo.BusConfig;

import java.util.List;

public interface BusService {
    //查询车辆信息
    List<BusConfig> selectBusConfigByLikeBusName(String busName,String crity);

    //查询线路信息
    Object findBusWay(String busId,String crity);

    //查询附近公交
    Object findBusWayNearby(String latitude, String longitude, String crity);

    //查询路线
    Object findBusWayNearbyBus(String openid, String stationid,String stationcname, String crity);
}
