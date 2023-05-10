package com.shinhan.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOMybatis {
	
	@Autowired
	SqlSession sqlSession;

	static final String NAMESPACE = "co.kr.firstzone.account.";
	
	static final Logger LOG = LoggerFactory.getLogger(AccountDAOMybatis.class);
	
	public void update1() {
		Map <String, Object> param = new HashMap<>();
		param.put("amount", 1);
		param.put("accountNo", "112");
		
		int resultCount = sqlSession.update(NAMESPACE + "update1", param);
		LOG.info(resultCount + "건 수정 --- 입금");
		
	}
	
	
	public void update2() {
		Map <String, Object> param = new HashMap<>();
		param.put("amount", 1);
		param.put("accountNo", "113");
		
		int resultCount = sqlSession.update(NAMESPACE + "update2", param);
		LOG.info(resultCount + "건 수정 --- 출금");
		
	}
	

}
