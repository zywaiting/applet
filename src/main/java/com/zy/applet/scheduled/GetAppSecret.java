package com.zy.applet.scheduled;

import com.zy.applet.service.AppletConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时获取AppSecret
 */
@Component
@EnableScheduling
public class GetAppSecret {

    @Autowired
    private AppletConfigService configService;

    @Scheduled(cron = "0 0/30 * * * ?")
    public void getAppSecret(){
        System.out.println("1111111");
        configService.updateAppSecret();
    }
}
