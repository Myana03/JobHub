package com.myana.springbootrest.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class VadlidateAspect {
	private static final Logger LOGGER=LoggerFactory.getLogger(VadlidateAspect.class);
	
	@Around("execution(* com.telusko.springbootrest.service.JobService.getJob(..)) && args(postId)")
	public Object validateandUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {
		if(postId<0) {
			postId = -postId;
			LOGGER.info("updated the negative value of postid");
		}
		Object obj = jp.proceed(new Object[] {postId});
		
		return obj;
	}

}


