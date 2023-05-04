package com.firstzone.aop1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class StopWatchAdvice implements MethodInterceptor {
	 public Object invoke(MethodInvocation invocation) throws Throwable {
	//보조업무
	System.out.println("StopWatchAdvice:[메서드 호출 전" + invocation.getMethod());
	StopWatch watch = new StopWatch("계산시간");
	watch.start();
	//주업무를 수행한다.
	Object object = invocation.proceed();
	//보조업무
	System.out.println("StopWatchAdvice:[메서드 호출 후" + invocation.getMethod());
	watch.stop();
	System.out.println("주업무 수행 시간:" + watch.getTotalTimeMillis());
	System.out.println(watch.prettyPrint());
	return object;
	}
	}