package com.zy.applet.controller.hzshyz;

import com.zy.applet.pojo.BusConfig;
import com.zy.applet.service.RealTimeBusService;
import com.zy.applet.utils.ResponseMessageUtils;
import com.zy.applet.utils.busUtils.SouZhouBusUtils;
import com.zy.applet.wxchat.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class RealTimeBusController {

    private final static Logger logger = LoggerFactory.getLogger(RealTimeBusController.class);

    @Autowired
    private RealTimeBusService realTimeBusService;

    @RequestMapping(value = "api/realTimeBus")
    public ResponseMessageUtils realTimeBus(String crity,String busName) {
        logger.info("调用了realTimeBus接口---------------api/realTimeBus");

        List<BusConfig> busConfigList = realTimeBusService.selectBusConfigByCrityAndBusName(crity, busName);
        if ("苏州".equals(crity)) {
            SouZhouBusUtils.Result result = SouZhouBusUtils.souZhouBusUtils(busConfigList.get(0).getBusId());
            return ResponseMessageUtils.ok(result);
        }

        return ResponseMessageUtils.ok();
    }

    public static void main(String[] args) {


        SouZhouBusUtils.Result result = SouZhouBusUtils.souZhouBusUtils("10000573");

        List<SouZhouBusUtils.Data> data = result.getData();
        SouZhouBusUtils.Result resultNew = new SouZhouBusUtils.Result();
        List<SouZhouBusUtils.Data> dataNew = new ArrayList<>();
        for (SouZhouBusUtils.Data datum : data) {
            if (StringUtils.isNotBlank(datum.getBusInfo())) {
                dataNew.add(datum);
            }

        }
        resultNew.setData(dataNew);
        String s = JsonUtils.toJson(resultNew);
        System.out.println(s);
    }

}
