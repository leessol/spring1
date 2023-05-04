package com.firstzone.aop2;

import org.aopalliance.intercept.Joinpoint;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//보조 업무
@Component
@Aspect
@Order(1)
public class LoggingAdvice {

	// pointcut 설정
	@Pointcut("execution(* add(int))||execution(* *(int,int))") // 주기능의 어디다가 넣을 건지
	public void targetMethod2() {
	}
	
	//주업무의 수행 전
	@Before("targetMethod2()")
	public void before(JoinPoint jp) {
		System.out.println("--------------- LoggingAdvice before---------------");
		System.out.println("[LoggingAdvice  함수이름:  " + jp.getSignature().getName() + " ]");
		
	}
	
	//주업무의 수행 후
	@After("targetMethod2()")
	public void after() {
		System.out.println("---------------LoggingAdvice after---------------");
	}
	
	
	//리턴 후에 
	@AfterReturning("targetMethod2()")
	public void afterReturn() {
		System.out.println("---------------LoggingAdvice @AfterReturning---------------");
	}
	
	
	// 해당 메서드에서 예외 발생 시 실행 
	@AfterThrowing("targetMethod2()")
	public void afterThrowing() {
		System.out.println("---------------LoggingAdvice @AfterThrowing---------------");
	}

	// 주업무의 전후에 수행
	@Around("targetMethod2()")
	public Object aroundTarget2(ProceedingJoinPoint joinPoint) throws Throwable {
		// 주 업무 전
		System.out.println("[LoggingAdvice 주 업무 전에 수행] " + joinPoint.getSignature().getName() + "메서드");

		Object obj = joinPoint.proceed(); // 주업무 수행

		// 주 업무 후
		System.out.println("[LoggingAdvice 주 업무 후에 수행] " + joinPoint.getSignature().getName() + "메서드");

		return obj; // 주업무 결과 리턴
	}

	
//	public Object invoke(MethodInvocation invocation) throws Throwable {
//		System.out.println("[메서드 호출 전 : LogginAdvice");
//		System.out.println(invocation.getMethod() + "메서드 호출 전");
//		// 주업무를 수행한다.
//		Object object = invocation.proceed();
//		// 주업무 수행후 돌아와서 수행한다.
//		System.out.println("[메서드 호출 후 : loggingAdvice");
//		System.out.println(invocation.getMethod() + "메서드 호출 후");
//		return object;
//	}

}
