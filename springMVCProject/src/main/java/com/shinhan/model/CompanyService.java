package com.shinhan.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinhan.vo.AdminVO;
import com.shinhan.vo.DeptVO;
import com.shinhan.vo.EmpVO;
import com.shinhan.vo.JobVO;
import com.shinhan.vo.LocationVO;

@Service
public class CompanyService {

	@Autowired
	CompanyDAO dao;
	
	public List<EmpVO> managerSelectAll() {
		return dao.managerSelectAll();
	}
	
	public List<JobVO> jobSelectAll() {
		return dao.jobSelectAll();
	}
	
	public List<DeptVO> deptSelectAll() {
		return dao.deptSelectAll();
	}
	
	public List<AdminVO> managerThreeSelect() {
		return dao.managerThreeSelect();
	}
	
	public List<LocationVO> locationSelectAll() {
		return dao.locationSelectAll();
	}
}
