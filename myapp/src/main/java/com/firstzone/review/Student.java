package com.firstzone.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Component("my")
@ToString
@Setter
@Getter
public class Student {
	private String studentId;
	private String studentName;
	private String major;
	
	@Autowired //자동으로 만들어서 주입됨. 
	//반드시 만들어서 넣어줘야 하기때문에 Address에 Component 빼면 안된다. 
	private Address addr;
	
	
	public Student() {	
		System.out.println("noArgument");
	}

	/**
	 * @param studentId
	 * @param studentName
	 * @param major
	 */
	public Student(String studentId, String studentName, String major) {
		System.out.println("allArgument");
	}
	
	
	
	
}
