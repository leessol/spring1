package com.shinhan.section07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shinhan.section03.EmpService;

public class App07 {

	public static void main(String[] args) {
		//ApplicationContext: 로드 시 bean 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("section04.xml");
		DeptController controller = context.getBean("deptController",DeptController.class);
		controller.f1();
				
	}

}
