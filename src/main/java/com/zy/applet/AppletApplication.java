package com.zy.applet;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
@SpringBootApplication
public class AppletApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppletApplication.class, args);
	}

}
