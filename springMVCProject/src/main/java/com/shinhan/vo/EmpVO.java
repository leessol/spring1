package com.shinhan.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//JavaBeans 湲곗닠: 蹂��닔 �젒洹� 吏��젙�옄�뒗 private, setter/getter, 湲곕낯 �깮�꽦�옄
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

//VO �뜲�씠�꽣 set: �빟媛� json �뀑 媛숈� �뒓�굦
public class EmpVO {
		
		
	 private Integer employee_id;
	 private String first_name;
	 private String last_name;
	 private String email;
	 private String phone_number;
	 private Date hire_date;
	 private String job_id;
	 private Double salary; 
	 //jsp 페이지에서 값 입력안함 --> null이다. 
	 //근데 null을 double(기본형)타입에 넣으려고 하면 오류이다. 
	 //그래서 Double로 바꾸면 null도 허용한다. 
	 //그리고 Mybatis에서 그 null을 허용한다는 처리가 sqlMapConfig.xml 파일에서 jdbcTypeForNull 설정을 해줘야한다. 
	 //이렇게 안하면, mapper.xml 파일에서 #{salary, jdbcType=INTEGER} 이렇게 해줘야 함. (불편)
	 private Double commission_pct;
	 private Integer manager_id;
	 private Integer department_id;
}





















