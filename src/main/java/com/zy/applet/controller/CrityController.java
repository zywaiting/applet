package com.zy.applet.controller;

import com.zy.applet.pojo.Crity;
import com.zy.applet.service.CrityService;
import com.zy.applet.utils.ListSplitUtils;
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
    @Autowired
    private CrityService crityService;
    @RequestMapping(value = "api/crity")
    public List findOneCrity() {
        return ListSplitUtils.createList(crityService.findCrity(),4);
    }

    /**
     * 查询城市简介
     * @return
     * */
    @RequestMapping(value = "api/crityinfo")
    public List findCrityInfo(String crity) {
        return crityService.findCityInfo(crity);
    }

    /**
     * 查询主图片
     * @return
     */
    @RequestMapping(value = "api/critymainpicture")
    public List findCrityMainPicture(String crity) {
        return crityService.findCityMainPicture(crity);
    }

    /**
     * 查询生活数据
     */
    @RequestMapping(value = "api/critylife")
    public List findCrityLife(String crity){
        return crityService.findCrityLife(crity);
    }
}
