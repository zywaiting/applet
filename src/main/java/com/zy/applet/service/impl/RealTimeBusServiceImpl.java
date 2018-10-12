package com.zy.applet.service.impl;

import com.zy.applet.mapper.RealTimeBusMapper;
import com.zy.applet.pojo.BusConfig;
import com.zy.applet.service.RealTimeBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealTimeBusServiceImpl implements RealTimeBusService {

    @Autowired
    private RealTimeBusMapper realTimeBusMapper;

    @Override
    public Integer inster(String post) {
        return realTimeBusMapper.inster(post);
    }

    @Override
    public String select() {
        return realTimeBusMapper.select();
    }

    @Override
    public List<BusConfig> selectBusConfigByCrityAndBusName(String crity, String busName) {
        return realTimeBusMapper.selectBusConfigByCrityAndBusName(crity,busName);
    }
}
