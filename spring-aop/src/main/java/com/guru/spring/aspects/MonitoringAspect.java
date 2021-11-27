/**
 * @author Rajaguru Paramasivam
 * 26-Nov-2021 3:46:31 pm
 * rajagurup11@gmail.com
 */
package com.guru.spring.aspects;

import java.time.Duration;
import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitoringAspect {

	@Around("@annotation(MonitoringTime)")
	public Object monitorMethodTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		LocalDateTime startTime = LocalDateTime.now();
		Object proceed = proceedingJoinPoint.proceed();
		LocalDateTime endTime = LocalDateTime.now();

		String method = proceedingJoinPoint.getSignature().getName();
		Logger logger = LoggerFactory.getLogger(proceedingJoinPoint.getSignature().getDeclaringTypeName());
		logger.warn("Method [" + method + "] took " + Duration.between(startTime, endTime).getSeconds() + " seconds.");
		return proceed;
	}
}
