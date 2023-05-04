package com.shinhan.section07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("deptService") // @Component + service  역할 --> 앞에 소문자로 한것이 디폴트 이름이다. 
public class DeptService {
	
	@Autowired //DeptDAO deptDAO = new DeptDAO() --> 이것은 의존 관계가 강하다. 나중에 의존하는 것이 바뀌면 같이 바꾸어 줘야 하니깐. 차라리 만들어서 주자. 
	// 차이는...! xml 하나를 바꾸는 것 이게 아니었음, 전부 다 바꿔야 한다. 
	// 작성 위치는 : field(가장 일반적), 생성자, setter 모두 가능하다. 
	// 만들어서 자동 주입: 타입만 같으면 된다.
	 //--> 만약 같은 타입이 여러개 있다면 이름을 설정해 줘야 한다. (interface를 구현한 경우)
	@Qualifier("deptDAO2")
	DeptDAOInterface deptDAO11;
	
	
	public void work() {
		deptDAO11.deptALL();
	}
}
