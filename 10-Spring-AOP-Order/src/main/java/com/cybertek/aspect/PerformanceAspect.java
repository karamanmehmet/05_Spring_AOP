package com.cybertek.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Configuration
@Order(1)
public class PerformanceAspect {

	Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);
	
	
	@Around( "anyExecutionTimeOperation()")
	public void anyExecutionTimeOperationAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		

			    long beforeTime = System.currentTimeMillis();
			    Object result = null;
			    try {
			       result = proceedingJoinPoint.proceed();//Important
			      //If method throws Exception or any error occurs
			    } catch (Throwable throwable) {
			      throwable.printStackTrace();
			    }
			    long afterTime = System.currentTimeMillis();
			    System.out.println("Time taken to execute: "
			        + (afterTime - beforeTime) + "ms");
			 

	}
	
	

	
	@Pointcut("@annotation(com.cybertek.annotation.ExecutionTime)")
	private void anyExecutionTimeOperation() {} 
	
	


}
