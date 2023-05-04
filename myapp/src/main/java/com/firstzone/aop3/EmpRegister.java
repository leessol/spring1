package com.firstzone.aop3;

import org.springframework.stereotype.Component;

@Component
public class EmpRegister {
	public void register() {
		System.out.println("직원등록");
	}
	
	public void empInfo() {
		System.out.println("직원정보");
	}
	
	public void print(String info) {
		System.out.println("직원정보 print : " + info);
	}
}
