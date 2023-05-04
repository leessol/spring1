package com.shinhan.section02;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class People {
	private String name;
	private int age;
	private Car car;
	private List<String> major;
	private List<License> licenseList;
	private Map<String, Book> books;
	
	Set<String> friend;
	Properties myprofile;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public void setMajor(List<String> major) {
		this.major = major;
	}
	public void setLicenseList(List<License> licenseList) {
		this.licenseList = licenseList;
	}
	public void setBooks(Map<String, Book> books) {
		this.books = books;
	}
	public void setFriend(Set<String> friend) {
		this.friend = friend;
	}
	public void setMyprofile(Properties myprofile) {
		this.myprofile = myprofile;
	}
	
	
	
	
	
	
}
