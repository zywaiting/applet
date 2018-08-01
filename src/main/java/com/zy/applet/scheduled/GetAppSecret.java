package com.zy.applet.scheduled;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时获取AppSecret
 */
@Component
@EnableScheduling
public class GetAppSecret {

    @Scheduled(cron = "*/20 * * * * ?")
    public void getAppSecret(){
        //System.out.println("111111111");
    }
}
