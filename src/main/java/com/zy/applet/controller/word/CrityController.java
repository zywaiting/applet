package com.zy.applet.controller.word;

import com.zy.applet.service.CrityService;
import com.zy.applet.utils.ListSplitUtils;
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
public class CrityController {

    private final static Logger logger = LoggerFactory.getLogger(CrityController.class);
    @Autowired
    private CrityService crityService;
    @RequestMapping(value = "api/crity")
    public List findOneCrity() {
        logger.info("调用了查询城市接口---------------api/crity");
        return ListSplitUtils.createList(crityService.findCrity(),4);
    }

    /**
     * 查询城市简介
     * @return
     * */
    @RequestMapping(value = "api/crityinfo")
    public List findCrityInfo(String crity) {
        logger.info("调用了查询城市简介接口---------------api/crityinfo:{}",crity);
        return crityService.findCityInfo(crity);
    }

    /**
     * 查询城市图片
     * @return
     */
    @RequestMapping(value = "api/critymainpicture")
    public List findCrityMainPicture(String crity) {
        logger.info("调用了查询城市图片接口---------------api/critymainpicture:{}",crity);
        return crityService.findCityMainPicture(crity);
    }

    /**
     * 查询生活数据
     */
    @RequestMapping(value = "api/critylife")
    public List findCrityLife(String crity){
        logger.info("调用了查询生活数据接口---------------api/critylife:{}",crity);
        return crityService.findCrityLife(crity);
    }
}
