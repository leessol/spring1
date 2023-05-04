package com.shinhan.section07;

import org.springframework.stereotype.Repository;

//Bean 만들기 (스프링이 생성하고 소멸하고 것을 관리하는 객체)
// 1)XML 파일에 등록: <bean id="deptDAO" class="com.shinhan.section07.DeptDAO" />
//	--> 너무 불편. bean이 너무 많음. 객체 생성마다 다 만들어줘야 하니깐
// 2)Annotation 사용: meta data를 사용, 가독성이 좋다. @Component, @Repository @Service @Controller
// context:component-scan으로 패키지를 설정한다. 위의 @ 가 전부 읽힌다. 

@Repository("deptDAO2")
public class DeptDAO2 implements DeptDAOInterface {
	
	@Override
	public void deptALL() {
		System.out.println("2. 모든 부서의 정보를 return 한다. ");
	}
}
