package com.shinhan.section04;

import org.springframework.stereotype.Repository;

@Repository //DB를 제어 
public class EmpDAO {
	
	public EmpDAO() {
		System.out.println("EmpDAO default 생성자");
	}
	
	public void selectAll() {
		System.out.println("모든 직원을 조회한다. ");
	}
}
