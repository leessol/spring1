package com.shinhan.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shinhan.vo.EmpVO;

//DAO (Data Access Object) : DB업무,, crud,, insert, select, update, delete 
@Repository // @Component + DAO
public class EmpDAOMybatis {

	@Autowired // 타입이 같으면 자동으로 Injection
	SqlSession sqlSession;
	static final String NAMESPACE = "co.kr.firstzone.emp.";
	static final Logger LOG = LoggerFactory.getLogger(EmpDAOMybatis.class);

	public List<EmpVO> selectAll() {
		List<EmpVO> emplist = sqlSession.selectList(NAMESPACE + "selectAll");
		LOG.info(emplist.toString());
		return emplist;
	}

	// 특정직원 조회- 한 row
	public EmpVO selectById(int empid) {
		// selectOne: 한건 select
		EmpVO emp = sqlSession.selectOne(NAMESPACE + "selectById", empid);
		LOG.info(emp.toString());
		return emp;
	}

	// 특정부서 직원만 조회 - 여러건
	public List<EmpVO> selectByDept(int deptid) {
		// selectList: 여러건 select
		List<EmpVO> emplist = sqlSession.selectList(NAMESPACE + "selectByDept", deptid);
		LOG.info(emplist.toString());
		return emplist;
	}

	// 조건 여러개: deptid, jobid, salary - 여러건
	// EmpVO class 이용
	public List<EmpVO> selectByCondition(Integer [] deptid, String jobid, Double salary, Date hireDate) {

		// map 이용
		Map<String, Object> mapData = new HashMap<>();
		if(deptid.length == 0) deptid = null; // deptid 값이 없을 때 
		mapData.put("deptid", deptid);
		mapData.put("jobid", jobid);
		mapData.put("salary", salary);
		mapData.put("hireDate", hireDate);

		// vo 이용
//		EmpVO emp = new EmpVO();
//		emp.setDepartment_id(deptid);
//		emp.setJob_id(jobid);
//		emp.setSalary(salary);
//		emp.setHire_date(hireDate);
//		LOG.info("Ddd" + emp.toString());
		List<EmpVO> emplist = sqlSession.selectList(NAMESPACE + "selectByCondition", mapData);
		LOG.info(emplist.toString());
		return emplist;
	}

	// 준범이꺼: 하나씩 select한다 -- 단점: 네트워크를 많이 왔따갔다 함
	public List<EmpVO> selectByCondition2(Integer[] deptid, String jobid, Double salary, Date hireDate) {

		List<EmpVO> emplistResult = new ArrayList<>();
		List<EmpVO> emplist = null;

		// vo 이용
		// 전체적인 경우 deptid = {0}
		for (Integer dept : deptid) {

			EmpVO emp = new EmpVO();
			emp.setDepartment_id(dept);
			emp.setJob_id(jobid);
			emp.setSalary(salary);
			emp.setHire_date(hireDate);
			emplist = sqlSession.selectList(NAMESPACE + "selectByCondition2", emp);
			LOG.info(emplist.toString());
			emplist.forEach(aa -> emplistResult.add(aa));
		}
		return emplistResult;
	}

	// 신규직원등록(insert)
	// EmpVO --> 하나하나 컬럼을 매개 인자로 넣는게 아니라 그냥 EmpVO 자체를 들고 다닌다.
	// 데이터 가방이라고 생각하면 됨. --> 그렇지 않으면 컬럼이 만약 몇십개가 되면 하나하나 개별로 들고 다녀야 함.
	public int empInsert(EmpVO emp) {
		// int The number of rows affected by the insert.
		// insert의 영향을 받은 row만 들어온다
		int result = sqlSession.insert(NAMESPACE + "insert", emp);
		LOG.info(result + "건 입력");
		return result;

	}

	// 직원정보 수정
	public int empUpdate(EmpVO emp) {
		int result = sqlSession.update(NAMESPACE + "update", emp);
		LOG.info(result + "건 수정");
		return result;
	}

	// 한건의 직원을 삭제하기
	public int empDelete(int empid) {
		int result = sqlSession.delete(NAMESPACE + "delete", empid);
		LOG.info(result + "건 삭제");
		return result;
	}

}
