package net.shinhan.advice;

import org.aopalliance.intercept.MethodInterceptor; //�̰� around�� ���� �ǹ� 
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
import org.springframework.util.StopWatch;

@Component
@Aspect
@Order(2)
public class StopWatchAdvice {

	// pointcut ����
	@Pointcut("within(com.shinhan.model.EmpDAOMybatis)")
	public void targetMethod3() {

	}

	// �־����� ���Ŀ� ����
	@Around("targetMethod3()")
	public Object aroundTarget2(ProceedingJoinPoint joinPoint) throws Throwable {
		// ��������
		System.out.println("StopWatchAdvice:[�޼��� ȣ�� ��" + joinPoint.getSignature().getName());
		StopWatch watch = new StopWatch("���ð�");
		watch.start();
		// �־����� �����Ѵ�.
		Object object = joinPoint.proceed();
		// ��������
		System.out.println("StopWatchAdvice:[�޼��� ȣ�� ��" + joinPoint.getSignature().getName());
		watch.stop();
		System.out.println("�־��� ���� �ð�:" + watch.getTotalTimeMillis());
		System.out.println(watch.prettyPrint());
		return object;
	}

}