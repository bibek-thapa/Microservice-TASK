package com.demo.ProfileService.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Autowired(required = false)
	private HttpServletRequest request;

	@Around("execution(* com.demo.ProfileService.controller..*(..)))")
	public Object profileAllControllerMethods(ProceedingJoinPoint joinPoint) throws Throwable {
		
		MDC.put("request", request.getRequestURI());

		Object retVal = null;
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();
		logger.info("Entering  class {}  with method {} and argument{}", className, methodName, joinPoint.getArgs());

		retVal = joinPoint.proceed();
		MDC.put("response", retVal.toString());
		logger.info("Exiting  class {}  with method {} and argument{}", className, methodName, joinPoint.getArgs());
		return retVal;

	}

}
