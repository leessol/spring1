package com.shinhan.model;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinhan.vo.EmpVO;

//꼭 전달만 하는 것이 아니라 조작하고 controller에 전달할 수 있음. 
//Service: 업무 로직 (데이터 유효성(보안처리) 등등 / 조작해서 controller에 보내야 한다. 등등 / 접점--> controller가 함수를 어떻게 부를것이며 DAO가 어떻게 접근하고 이런거 정의)
@Service //@Component + service
public class EmpService {
	
	@Autowired //Spring의 타입이 같으면 자동주입
	EmpDAOMybatis empDao;

//	// SP 호출
//	public EmpVO getSalary(int empid) {
//		return empDao.getSalary(empid);
//	}

	public List<EmpVO> selectAll() {
		return empDao.selectAll(); // empDao.selectAll() DAO꺼 호출해서 결과를 controller에 보내야 하니깐 바로 return해버린다.
	}

	public EmpVO selectById(int empid) {
		return empDao.selectById(empid);
	}

	public List<EmpVO> selectByDept(int deptid) {
		return empDao.selectByDept(deptid);
	}

	public List<EmpVO> selectByCondition(Integer[] deptid, String jobid, Double salary, Date hireDate) {
		return empDao.selectByCondition(deptid, jobid, salary, hireDate);
	}
	
	//준범이꺼: 하나씩 select한다 -- 단점: 네트워크를 많이 왔따갔다 함
	public List<EmpVO> selectByCondition2(Integer[] deptid, String jobid, Double salary, Date hireDate) {
		return empDao.selectByCondition2(deptid, jobid, salary, hireDate);
	}

//	public List<EmpVO> selectLAB() {
//		// controller에 전달하기 전에 조작하는 하고(뭔가 가공) 보낸다.
//		List<EmpVO> empList = empDao.selectLAB();
//		System.out.println("[Controller] 5번 작업: " + empList.size());
//		return empList;
//	}

	// 신규직원등록(insert)
	public String empInsert(EmpVO emp) {
		
		// 뭔가 추가로 처리해야 할 일이 있을 때.
		// controller로 전달하기 전에 가공하고 보낸다.
		int result = empDao.empInsert(emp);
		return result > 0 ? "성공" : "실패";
		
		
	}

	// 수정하기
	public String empUpdate(EmpVO emp) {
		int result = empDao.empUpdate(emp);
		return result > 0 ? "성공" : "실패";
	}

	// 삭제하기
	public String empDelete(int empid) {
		int result = empDao.empDelete(empid);
		return result > 0 ? "성공" : "실패";
	}

}
