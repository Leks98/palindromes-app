package com.javafee.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointcutDeclaration {
	@Pointcut("execution(* com.javafee.springdemo.controller.*.*(..))")
	private void loggingController() {
	}

	@Pointcut("execution(* com.javafee.springdemo.service.*.*(..))")
	private void loggingService() {
	}

	@Pointcut("execution(* com.javafee.springdemo.dao.*.*(..))")
	private void loggingDao() {
	}

	@Pointcut("loggingController() || loggingService() || loggingDao()")
	public void loggingAllFlow() {}
}
