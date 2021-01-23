package com.cybertek.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.cybertek.model.Product;

@Aspect
@Configuration
public class LoggingAspect {

	Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@AfterReturning(pointcut =  "anyGetProductOperation()", returning="results")
	public void afterReturningControllerAdvice(JoinPoint joinPoint,List<Product> results) {
		
		logger.info("After Returning( List Result ->  Method : {} - Results : {} ",joinPoint.getSignature().toShortString(),results);
		
	}
	
	@AfterReturning(pointcut =  "anyGetProductOperation()", returning="results")
	public void afterReturningControllerAdvice(JoinPoint joinPoint,Product results) {
		
		logger.info("After Returning(  Mono Result ->  Method : {} - Results : {} ",joinPoint.getSignature().toShortString(),results);
		
	}
	
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	private void anyGetProductOperation() {} 
	

}
