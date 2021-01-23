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
	
	@Before("anyDeletedProductOperation()")
	public void beforeControllerAdvice(JoinPoint joinPoint) {
		
		logger.info("Before(Sending Email)  ->  Method : {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
		
	}
	
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
	private void anyDeletedProductOperation() {} 
	

}
