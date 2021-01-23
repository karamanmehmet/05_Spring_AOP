package com.cybertek.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Configuration
@Order(0)
public class LoggingAspect {

	Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	
	@Before( "anyRestProductOperation()")
	public void anyRestProductControllerAdvice(JoinPoint joinPoint) {
		
		logger.info("Before ( Method : {} - Parameters : {} ",joinPoint.getSignature().toShortString(),joinPoint.getArgs());
		


	}
	
	

	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	private void anyRestProductOperation() {} 
	
	


}
