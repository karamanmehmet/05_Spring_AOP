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
	
	@Before("anyUpdateOperation()")
	public void beforeControllerAdvice(JoinPoint joinPoint) {
		
		logger.info("Before  ->  Method : {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
		
	}
	
	
	@Before("anyCategoryRepositoryFindByNameOperation()")
	public void beforeCategoryRepoAdvice(JoinPoint joinPoint) {
		
		logger.info("Before (findByName)  ->  Method : {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
		
	}
	
	
	
	@Pointcut("execution(* com.cybertek.controller.ProductController.up*(..))")
	private void anyUpdateOperation() {} 
	
	
	@Pointcut("execution(* com.cybertek.repository.CategoryRepository.findByName(String))")
	private void anyCategoryRepositoryFindByNameOperation() {} 
	

}
