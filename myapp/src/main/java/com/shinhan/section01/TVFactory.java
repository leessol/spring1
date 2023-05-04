package com.shinhan.section01;

public class TVFactory {
	//factory pattern
	//공장을 하나 만든다. 직접 new하는 게 아니라 서브 클래스가 그때 가서 필요하면 하는 것이다. 
	// 이렇게 안하면, 각 클래스의 생성자가 바뀌면 객체 생성할 때 다 바꿔여야 한다. 
	public static TV makeTV(String brand) {
		if(brand.equals("sam")) {
			return new SamsungTV();
		} else if(brand.equals("lg")) {
			return new LgTV();
		} 
		return null;
	}
}
