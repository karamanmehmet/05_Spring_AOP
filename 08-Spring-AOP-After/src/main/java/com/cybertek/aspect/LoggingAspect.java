package com.cybertek.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.cybertek.model.Product;

@Aspect
@Configuration
public class LoggingAspect {

	Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	
	@Before( "anyGetPutProductOperation()")
	public void beforeControllerAdvice(JoinPoint joinPoint) {
		
		logger.info("Before Calling( List Result ->  Method : {} - Parameters : {} ",joinPoint.getSignature().toShortString(),joinPoint.getArgs());
		
	}
	
	@AfterReturning(pointcut =  "anyGetPutProductOperation()", returning="results")
	public void afterReturningControllerAdvice(JoinPoint joinPoint,List<Product> results) {
		
		logger.info("After Returning( List Result ->  Method : {} - Results : {} ",joinPoint.getSignature().toShortString(),results);
		
	}
	
	@AfterReturning(pointcut =  "anyGetPutProductOperation()", returning="results")
	public void afterReturningControllerAdvice(JoinPoint joinPoint,Product results) {
		
		logger.info("After Returning(  Mono Result ->  Method : {} - Results : {} ",joinPoint.getSignature().toShortString(),results);
		
	}
	
	
	@AfterThrowing(pointcut =  "anyGetPutProductOperation()", throwing="exception")
	public void afterThrowingControllerAdvice(JoinPoint joinPoint,RuntimeException exception) {
		
		logger.info("After Throwing (  Send Emil to L2 Team ->  Method : {} - Exception : {} ",joinPoint.getSignature().toShortString(),exception.getMessage());
		
	}
	
	@After( "anyGetPutProductOperation()")
	public void afterControllerAdvice(JoinPoint joinPoint) {
		
		logger.info("After Finally (  Method : {} - has been processed ",joinPoint.getSignature().toShortString());
		
	}
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	private void anyGetPutProductOperation() {} 
	

}
