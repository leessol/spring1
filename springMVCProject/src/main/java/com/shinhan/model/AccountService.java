package com.shinhan.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service //@component + service
@Transactional(propagation = Propagation.REQUIRED)  //tracsaction 전파규칙 설정
public class AccountService {
	
	@Autowired
	AccountDAOMybatis dao;
	
	
	//이체 서비스
	public void transfer() {
		dao.update1(); //정상 구문
		dao.update2(); //비정상 구문
	}
}
