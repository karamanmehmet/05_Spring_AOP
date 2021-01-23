package com.cybertek.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

	Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution (* com.cybertek.controller.ProductController.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		
		logger.info("Before  ->  Method : {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
		
	}
	
}
