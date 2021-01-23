package com.cybertek.aspect;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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
	
	
	@Around( "anyPostProductOperation()")
	public Object anyPostControllerAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		logger.info("Before ( Method : {} - Parameters : {} ",proceedingJoinPoint.getSignature().toShortString(),proceedingJoinPoint.getArgs());
		
		List<Product> results = new ArrayList<>();
		try {
			results = (List<Product>) proceedingJoinPoint.proceed();
		}catch (Exception e) {
			// TODO: handle exception
			
			
		}
		
		logger.info("After ( Method : {} - Results : {} ",proceedingJoinPoint.getSignature().toShortString(),results);
		return results;

	}
	
	
	@Around( "anyPutProductOperation()")
	public Object anyPutControllerAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		logger.info("Before ( Method : {} - Parameters : {} ",proceedingJoinPoint.getSignature().toShortString(),proceedingJoinPoint.getArgs());
		
		List<Product> results = new ArrayList<>();
		try {
			//results = (List<Product>) proceedingJoinPoint.proceed();
		}catch (Exception e) {
			// TODO: handle exception
			
			
		}
		
		logger.info("After ( Method : {} - Results : {} ",proceedingJoinPoint.getSignature().toShortString(),results);
		return results;

	}

	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
	private void anyPostProductOperation() {} 
	
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
	private void anyPutProductOperation() {} 

}
