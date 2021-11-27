/**
 * @author Rajaguru Paramasivam
 * 26-Nov-2021 3:46:31 pm
 * rajagurup11@gmail.com
 */
package com.guru.spring.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("@annotation(LogMethod)")
	public void logMethodName(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		String params = Arrays.toString(joinPoint.getArgs());
		Logger logger = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringTypeName());
		logger.warn("Method [" + method + "] gets called with parameters " + params);
	}
}
