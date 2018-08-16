package com.zy.applet.controller;

import com.zy.applet.pojo.Travel;
import com.zy.applet.service.TravelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zy
 * 2018-8-15
 * 获取旅游信息
 */
@RestController
public class TravelController {
    private final static Logger logger = LoggerFactory.getLogger(TravelController.class);

    @Autowired
    private TravelService travelService;

    @RequestMapping(value = "api/travel")
    public List<Travel> findListTravel(@RequestParam("crity") String crity) {
        logger.info("调用了查询城市接口---------------api/travel");
        List<Travel> TravelList = travelService.findListTravel(crity);
        return TravelList;
    }
}
