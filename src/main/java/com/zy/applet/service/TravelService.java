package com.zy.applet.service;

import com.zy.applet.pojo.Travel;

import java.util.List;

public interface TravelService {
    //查询城市的旅游信息
    List<Travel> findListTravel(String crity);
}
