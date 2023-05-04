package com.shinhan.section04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("empSer") //Component 이면서 Service
public class EmpService {
	
	/* EmpDAO dao;
	
	!!!!!!!!!!! 필요가 없어짐. @Service떄문에 
	 * //1. 생성자를 통해서 Injection 하기 public EmpService(EmpDAO dao) { this.dao = dao; }
	 * 
	 * //2. setter을 통해서 Injection하기 public EmpService() {
	 * System.out.println("default 생성자"); }
	 * 
	 * public void setDao(EmpDAO dao) { this.dao = dao; }
	 */
	
	//type이 같으면 자동으로 주입한다.
	@Autowired
	EmpDAO dao;
	
	public void empAll() {
		dao.selectAll();
	}
}
