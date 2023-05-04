package com.firstzone.review;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@ToString
@Component
public class Address {
	String city;
	String zipNum;
}
