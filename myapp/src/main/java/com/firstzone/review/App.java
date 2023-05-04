package com.firstzone.review;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App {

	public static void main(String[] args) {
		f3();

	}

	private static void f3() {
		ApplicationContext context = new ClassPathXmlApplicationContext("review2.xml");
		Student s1 = context.getBean("my",Student.class);
		System.out.println(s1);
		System.out.println(s1.getStudentName());
		
	}

	//applicationContext: 는 로딩될 때, xml파일에 있는 객체가 전부 생성됨 
	private static void f2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("review.xml");
		
	}

	//BeanFactory: 을 할 때 그떄 객체가 생성되는 것이다. 메모리 낭비 안함. 필요할때만 객체가 생성되는 개념이다. 
	private static void f1() {
		Resource resource = new ClassPathResource("review.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		
		Student s1 = factory.getBean("student1",Student.class);
		System.out.println(s1);
		Student s2 = factory.getBean("student2",Student.class);
		System.out.println(s2);
		Student s3 = factory.getBean("student2",Student.class);
		
	}

}
