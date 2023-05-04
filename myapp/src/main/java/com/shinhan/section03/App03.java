package com.shinhan.section03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//controller 역할
public class App03 {
	public static void main(String[] args) {
		//ApplicationContext: 로드 시 bean 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("section03.xml");
		EmpService service = context.getBean("service1",EmpService.class);
		service.empAll();
				
	}
}
