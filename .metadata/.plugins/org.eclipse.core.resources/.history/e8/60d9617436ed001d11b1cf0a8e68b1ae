package com.shinhan.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinhan.vo.EmpVO;

@Service //@Component + service(business)
public class EmpService {
	
	@Autowired // EmpDAO empDAO = new EmpDAO(); ¶û °°Àº ÀÇ¹Ì
	EmpDAO empDAO;
	
	public List<EmpVO> selectAll() {
		return empDAO.selectAll();
	}
}
