package com.shinhan.section01;

public class TVUser {
	public static void main(String[] args) {
		f1();
		f2();
		f3();
	}

	private static void f3() {
		TV tv = TVFactory.makeTV("sam");
		tv.powerOn();
		tv.powerOff();
		
	}

	private static void f2() {
		TV tv = new SamsungTV(); //인터페이스를 이용하면 더 좋다. 
		tv.powerOn();
		tv.powerOff();	
		
	}

	private static void f1() {
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.powerOff();		
	}
}
