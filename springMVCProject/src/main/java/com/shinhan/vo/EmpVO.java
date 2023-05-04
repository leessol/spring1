package com.shinhan.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//JavaBeans 기술: 변수 접근 지정자는 private, setter/getter, 기본 생성자
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

//VO 데이터 set: 약간 json 셋 같은 느낌
public class EmpVO {
		
		
	 private int employee_id;
	 private String first_name;
	 private String last_name;
	 private String email;
	 private String phone_number;
	 private Date hire_date;
	 private String job_id;
	 private double salary;
	 private double commission_pct;
	 private int manager_id;
	 private int department_id;
}





















