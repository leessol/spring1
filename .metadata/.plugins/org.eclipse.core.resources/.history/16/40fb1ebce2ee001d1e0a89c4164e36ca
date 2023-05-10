package com.firstzone.aop3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {

	/* @Pointcut("execution(* print()) || execution(* *(String))") */
	@Pointcut("execution(* print(..))")
	public void loggingAdvice() {}
	
	
	@Pointcut("execution(* *Info())")
	public void loggingAdvice2() {}
	
	@Around("loggingAdvice2()")
	public Object aroundTarget2(ProceedingJoinPoint joinPoint) throws Throwable {
		Object obj = joinPoint.proceed(); // 주업무 수행
		return obj; // 주업무 결과 리턴
	}

	@Around("loggingAdvice()")
	public Object aroundTarget(ProceedingJoinPoint joinPoint) throws Throwable {

		// 주 업무 전
		System.out.println("[LoggingAdvice 주 업무 전에 수행: class 이름  ==> ] " + joinPoint.getTarget().getClass().getName() + "메서드");

		Object obj = joinPoint.proceed(); // 주업무 수행

		// 주 업무 후
		System.out.println("[LoggingAdvice 주 업무 후에 수행: 함수 이름  ==> ] " + joinPoint.getSignature().getName() + "메서드");

		return obj; // 주업무 결과 리턴
	}
	
	
}
