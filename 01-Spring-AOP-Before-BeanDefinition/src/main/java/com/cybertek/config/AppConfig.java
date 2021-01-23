package com.cybertek.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.cybertek.aspect.LoggingAspect;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
	
	
	@Bean
	LoggingAspect loggingAspect() {
		return new LoggingAspect();
	}
	

}
