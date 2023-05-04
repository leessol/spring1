package com.firstzone.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop1.xml");
		Calculator cal = context.getBean("proxyCal",Calculator.class);
		cal.add(1,2);

	}

}
