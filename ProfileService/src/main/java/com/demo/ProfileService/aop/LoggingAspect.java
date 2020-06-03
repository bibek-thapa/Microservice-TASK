package com.demo.ProfileService.aop;

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
  
	
	
	@Around("execution(* com.demo.ProfileService.controller..*(..)))")
	public Object profileAllControllerMethods(ProceedingJoinPoint joinPoint) throws Throwable 
	{
		Object retVal = null;
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();
		logger.info("Before Executing "+ className + " with method "+ methodName);
		retVal = joinPoint.proceed();
		logger.info("After Executing "+ className + " with method "+ methodName);
		return retVal;
		
	}

}
