package com.myana.springbootrest.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoringAspect {
	private static final Logger LOGGER=LoggerFactory.getLogger(PerformanceMonitoringAspect.class);
	
	@Around("execution(* com.telusko.springbootrest.service.JobService.*(..))")
	public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
		long start = System.currentTimeMillis();
		Object obj = jp.proceed();
		long end = System.currentTimeMillis();
		
		LOGGER.info("timee taken is :" +jp.getSignature().getName()+ " " +(end-start) + "ms");
		
		return obj;
	}

}
