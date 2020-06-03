package com.demo.CustomerMS.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
  
	@Around("execution(* com.demo.CustomerMS.serviceimpl..*(..))")
	public Object profileAllServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable 
	{
		Object retVal = null;
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();
		
		logger.info("Entering  class {}  with method {} and argument{}",className, methodName,joinPoint.getArgs());
		retVal = joinPoint.proceed();
		logger.info("Exiting  class {}  with method {} and argument{}",className, methodName,joinPoint.getArgs());
		return retVal;
		
	}
	
	@Around("execution(* com.demo.CustomerMS.controller..*(..)))")
	public Object profileAllControllerMethods(ProceedingJoinPoint joinPoint) throws Throwable 
	{
		Object retVal = null;
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();
		logger.info("Entering  class {}  with method {} and argument{}",className, methodName,joinPoint.getArgs());
		retVal = joinPoint.proceed();
		logger.info("Exiting  class {}  with method {} and argument{}",className, methodName,joinPoint.getArgs());
		return retVal;
		
	}

}
