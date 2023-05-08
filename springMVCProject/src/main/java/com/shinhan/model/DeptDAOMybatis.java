package com.shinhan.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shinhan.vo.DeptVO;

@Repository
public class DeptDAOMybatis {

	@Autowired
	SqlSession sqlSession;
	String namespace = "com.shinhan.dept.";
	
	Logger logger = LoggerFactory.getLogger(DeptDAOMybatis.class);
	

	// 부서 전부 조회
	public List<DeptVO> deptSelectAll() {
		List<DeptVO> deptList = sqlSession.selectList(namespace+"selectAll");
		logger.info("mybatis --- deptSelectAll: ");
		return deptList;
	}
	
	//부서 insert
	public int deptInsert(DeptVO dept) {
		logger.info("mybatis --- deptInsert: " + dept);
		return sqlSession.insert(namespace+"insert", dept);
	}
	
	// 특정부서 조회- 한 row
	public DeptVO selectById(int deptid) {
		logger.info("mybatis --- selectById: " + deptid);
		return sqlSession.selectOne(namespace+"selecById", deptid);
	}
	
	
	public int deptUpdate(DeptVO dept) {
		logger.info("mybatis --- deptUpdate: " + dept);
		return sqlSession.update(namespace+"update", dept);
	}
	
	public int deptDelete(int deptid) {
		logger.info("mybatis --- deptDelete: " + deptid);
		return sqlSession.delete(namespace+"delete", deptid);
	}
	
		
}
