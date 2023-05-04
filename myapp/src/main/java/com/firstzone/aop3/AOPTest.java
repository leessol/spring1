package com.firstzone.aop3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop3.xml");
		MemberRegister member = context.getBean("memberRegister",MemberRegister.class);
		EmpRegister emp = context.getBean("empRegister",EmpRegister.class);
		
		emp.print("이솔");
		member.print();
		

	}

}
