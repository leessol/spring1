package com.shinhan.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinhan.vo.DeptVO;

@Service
public class DeptService {
	
	@Autowired
	DeptDAOMybatis deptdao;
	//DeptDAO deptdao;
	
	
	public List<DeptVO> deptSelectAll() {
		return deptdao.deptSelectAll();
	}
	
	public String deptInsert(DeptVO dept) {
		int result = deptdao.deptInsert(dept);
		return result > 0? "����" : "����";
	}
	
	
	public DeptVO selectById(int deptid) {
		return deptdao.selectById(deptid);
	}
	
	public String deptUpdate(DeptVO dept) {
		int result = deptdao.deptUpdate(dept);
		return result > 0 ? "����" : "����";
	}
	
}