package com.myana.springbootrest.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class LoggingAspect {

		private static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);
		
		@Before("execution(* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
		public void logMethodCalled(JoinPoint jp) {
		    LOGGER.info("method called "+jp.getSignature().getName());
		}
		@After("execution(* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
		public void logMethodExecuted(JoinPoint jp) {
		    LOGGER.info("method executed "+jp.getSignature().getName());
		}
		@AfterThrowing("execution(* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
		public void logMethodCrash(JoinPoint jp) {
		    LOGGER.info("method crashed with exceptions "+jp.getSignature().getName());
		}
		
		@AfterReturning("execution(* com.telusko.springbootrest.service.JobService.getJob(..)) || execution(* com.telusko.springbootrest.service.JobService.updateJob(..))")
		public void logMethodExecuteSuccess(JoinPoint jp) {
		    LOGGER.info("method executed without exceptions "+jp.getSignature().getName());
		}
}
