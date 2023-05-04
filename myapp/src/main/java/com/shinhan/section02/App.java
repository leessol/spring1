package com.shinhan.section02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.shinhan.section01.LgTV;
import com.shinhan.section01.SamsungTV;
import com.shinhan.section01.TV;

public class App {

	public static void main(String[] args) {
		f3();

	}

	
	
	
	private static void f4() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("section02.xml");
		TV tv = ctx.getBean("lg", LgTV.class);
		tv.powerOn();
		tv.powerOff();
	}

	private static void f3() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("section02.xml");
		People a = ctx.getBean("p2",People.class);
		People b = ctx.getBean("p2",People.class);
		
		System.out.println(a==b);
		//주소비교 singleton이면 true / prototype이면 false
		
	}

	private static void f2() {
		//사용하지 않아도 이미 객체가 다 생성된다. --> getBean 안해도 이미 생성자들은 다 생성됨. 
		//Bean 객체 생성보다 더 기능이 많다. 
		//ApplicationContext: 사용되기 전에 빈을 미리 로딩
		//메모리 많이 차지 (어플리케이션에서는 보통 이걸 많이 쓰고)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("section02.xml");
		Car c1 = ctx.getBean("car1",Car.class);
		Car c2 = ctx.getBean("car2",Car.class);
		Car c3 = ctx.getBean("car3",Car.class);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
	}

	private static void f1() {
		//IOC 제어가 역전됨. Spring이 제어한다. Java가 아니라 
		//BeanFactory: 사용하면 빈이 로딩됨. 
		//메모리 적게 차지 (모바일에서 많이 사용)
		//필요 없는건 로딩이 안되기 때문에. 
		Resource resource = new ClassPathResource("section02.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		Car c1 = (Car)factory.getBean("car1"); //factory.getBean()은 Object 타입이라 형변환 해야한다. 
		System.out.println(c1);
		
		
		Car c2 = factory.getBean("car2",Car.class); //(객체이름, 타입)
		System.out.println(c2);
		
		Car c3 = factory.getBean("car3",Car.class); //(객체이름, 타입)
		System.out.println(c3);
		
		
	}
	

}
