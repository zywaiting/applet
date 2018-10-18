package com.zy.applet.service.impl;

import com.zy.applet.mapper.BusMapper;
import com.zy.applet.pojo.BusConfig;
import com.zy.applet.pojo.KeyValue;
import com.zy.applet.service.BusService;
import com.zy.applet.utils.busUtils.SouZhouBusUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusMapper busMapper;

    @Override
    public List<BusConfig> selectBusConfigByLikeBusName(String busName,String crity) {
        return busMapper.selectBusConfigByLikeBusName(busName,crity);
    }

    @Override
    public Object findBusWay(String busId, String crity) {
        if ("苏州".equals(crity)) {
            SouZhouBusUtils.Result result = SouZhouBusUtils.souZhouBusUtils(busId);
            List<SouZhouBusUtils.Data> data = result.getData();
            Integer number = 1;
            for (SouZhouBusUtils.Data datum : data) {
                datum.setNumber(number);
                number++;
            }
            result.setData(data);
            return result;
        }
        return null;
    }

    @Override
    public Object findBusWayNearby(String latitude, String longitude, String crity) {
        if ("苏州".equals(crity)) {
            return SouZhouBusUtils.souZhouBusUtils(latitude, longitude);
        }
        return null;
    }

    @Override
    public Object findBusWayNearbyBus(String openid, String stationid,String stationcname,String crity) {
        if ("苏州".equals(crity)) {
            SouZhouBusUtils.Result result = SouZhouBusUtils.souZhouBusUtils(stationid, 1);
            List<SouZhouBusUtils.Data> data = result.getData();
            for (SouZhouBusUtils.Data datum : data) {
                BusConfig busConfig = busMapper.selectBusConfigByBusId(datum.getBusId(), crity);
                datum.setBeginEnd(busConfig.getBeginEnd());
                datum.setStationCName(stationcname);
            }
            result.setData(data);
            return result;
        }
        return null;
    }
}
