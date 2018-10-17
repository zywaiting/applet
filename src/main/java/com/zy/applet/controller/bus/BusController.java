package com.zy.applet.controller.bus;

import com.zy.applet.pojo.BusConfig;
import com.zy.applet.service.BusService;
import com.zy.applet.utils.ResponseMessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * zy
 * 2018/7/18
 */
@RestController
public class BusController {

    private final static Logger logger = LoggerFactory.getLogger(BusController.class);
    @Autowired
    private BusService busService;
    @RequestMapping(value = "api/busconfig")
    public ResponseMessageUtils findLikeBus(String openid, String busname,String crity) {
        logger.info("调用了查询公交车---------------api/busconfig");
        List<BusConfig> busConfigList = busService.selectBusConfigByLikeBusName(busname,crity);
        return ResponseMessageUtils.ok(busConfigList);
    }

    @RequestMapping(value = "api/busway")
    public ResponseMessageUtils findBusWay(String openid, String busid,String crity) {
        logger.info("调用了查询公交车路线---------------api/buswag");
        Object busWay = busService.findBusWay(busid, crity);
        return ResponseMessageUtils.ok(busWay);
    }


    @RequestMapping(value = "api/buswaynearby")
    public ResponseMessageUtils findBusWayNearby(String openid, String latitude, String longitude, String crity) {
        logger.info("调用了查询附近公交车站---------------api/buswaynearby");
        Object busWay = busService.findBusWayNearby(latitude, longitude, crity);
        return ResponseMessageUtils.ok(busWay);
    }

}
