package com.shinhan.section03;

public class EmpService {
	
	EmpDAO dao;
	
	//1. 생성자를 통해서 Injection 하기
	public EmpService(EmpDAO dao) {
		this.dao = dao;
	}
	
	//2. setter을 통해서 Injection하기
	public EmpService() {
		System.out.println("default 생성자");
	}
	
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}
	
	public void empAll() {
		dao.selectAll();
	}
}
