package com.shinhan.section05;

import org.springframework.stereotype.Component;

//Bean(Spring 은 객체를 Bean이라고 한다.  ) Car c1 = new Car()
//POJO (Plain Old Java Object)
//DTO (Data Transfer Object)
//VO ( Value Object)

@Component("myCar")
public class Car {
	private String model="ABC";
	private int price;
	
	
	
	public Car() {
		System.out.println("Car 의 default 생성자");
	}
	
	public Car(String model, int price) {
		System.out.println("Car의 argument 2개 생성자");
		this.model = model;
		this.price = price;
	}
	
	public String getModel() {
		System.out.println("Car --- getModel()");
		return model;
	}
	
	public void setModel(String model) {
		System.out.println("Car --- setModel()");
		this.model = model;
	}
	
	
	@Override
	public String toString() {
		return "Car [model=" + model + ", price=" + price + "]";
	}
	
	
}
