package com.zy.applet.service;

import com.zy.applet.pojo.BusConfig;

import java.util.List;

public interface RealTimeBusService {

    Integer inster(String post);

    String select();

    //查询车辆id
    List<BusConfig> selectBusConfigByCrityAndBusName(String crity, String busName);

}
