package com.cybertek.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

	Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("anyServiceAnnotatedOperation() || anyControllerOperation()")
	public void beforeControllerAdvice(JoinPoint joinPoint) {
		
		logger.info("Before  ->  Method : {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
		
	}
	
	
	
	@Pointcut("within(com.cybertek.controller..*)")
	private void anyControllerOperation() {} 
	
	
	@Pointcut("@within(org.springframework.stereotype.Service)")
	private void anyServiceAnnotatedOperation() {} 
	

}
