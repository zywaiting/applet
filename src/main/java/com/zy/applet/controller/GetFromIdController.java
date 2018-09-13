package com.zy.applet.controller;

import com.zy.applet.service.GetFromIdService;
import com.zy.applet.utils.ResponseMessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * zy
 * 2018/8/24
 */
@RestController
public class GetFromIdController {
    private final static Logger logger = LoggerFactory.getLogger(GetFromIdController.class);

    @Autowired
    private GetFromIdService getFromIdService;

    @RequestMapping(value = "api/getfromid")
    public ResponseMessageUtils getFromId(@RequestParam("fromId") String fromId,@RequestParam("openId") String openId) {
        logger.info("调用了获取fromid接口---------------api/getfromid");
        Integer number = getFromIdService.selectNumberByOpenId(openId);
        if (number==null){
            number=0;
        }
        Integer integer = getFromIdService.insterFromId(fromId, openId, number + 1);
        if (integer > 0) {
            return ResponseMessageUtils.ok();
        }
        return ResponseMessageUtils.error("获取fromid失败");
    }
}
