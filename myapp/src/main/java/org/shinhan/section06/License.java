package org.shinhan.section06;

import org.springframework.stereotype.Component;

@Component
public class License {
	private String title;
	private int year;
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "License [title=" + title + ", year=" + year + "]";
	}
	
	
	
	
}
