package com.shinhan.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinhan.vo.EmpVO;

@Service //@Component + service(business)
public class TestEmpService {
	
	@Autowired // EmpDAO empDAO = new EmpDAO(); �� ���� �ǹ�
	TestEmpDAO empDAO;
	
	public List<EmpVO> selectAll() {
		return empDAO.selectAll();
	}
}
