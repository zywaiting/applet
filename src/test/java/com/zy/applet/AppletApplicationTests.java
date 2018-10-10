package com.zy.applet;

import com.zy.applet.wxchat.config.WxMpProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableConfigurationProperties(WxMpProperties.class)
public class AppletApplicationTests {

	@Autowired
	private WxMpProperties properties;
	@Test
	public void contextLoads() {
		System.out.println(properties.getConfigs().get(0).getAppId());
	}

}
