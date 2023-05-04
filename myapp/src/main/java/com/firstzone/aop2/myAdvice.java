package com.firstzone.aop2;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.MethodBeforeAdvice; // 이게 @before
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class myAdvice {
	// pointcut 설정
	@Pointcut("execution(* *(int,int))")
	public void targetMethod4() {

	}

	// 주업무 수행전
	@Before("targetMethod4()")
	public void before(JoinPoint jp) {
		System.out.println("--------------- myAdvice before---------------");
		System.out.println("[myAdvice  함수이름:  " + jp.getSignature().getName() + " ]");

	}

	// 주업무의 수행 후
	@After("targetMethod4()")
	public void after() {
		System.out.println("---------------myAdvice after---------------");
	}

	// 리턴 후에
	@AfterReturning("targetMethod4()")
	public void afterReturn() {
		System.out.println("---------------myAdvice @AfterReturning---------------");
	}

	// 해당 메서드에서 예외 발생 시 실행
	@AfterThrowing("targetMethod4()")
	public void afterThrowing() {
		System.out.println("---------------myAdvice @AfterThrowing---------------");
	}

	@Around("targetMethod4()")
	public Object aroundTarget2(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("-----------------myAdvice MethodBeforeAdvice------------------");
		System.out.println("myAdvice 함수이름은,,,, " + joinPoint.getSignature().getName());
		Object obj = joinPoint.proceed(); // 주업무 수행

		System.out.println("-----------------------------------------------------");
		return obj; // 주업무 결과 리턴
	}
	
//	public void before(Method method, Object[] args, Object target) throws Throwable {
//		System.out.println("-----------------MethodBeforeAdvice------------------");
//		System.out.println("함수이름은,,,, " + method.getName());
//		System.out.println("-----------------------------------------------------");
//	}

}
