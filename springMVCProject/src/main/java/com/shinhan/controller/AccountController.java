package com.shinhan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinhan.model.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService aService;

	@GetMapping(value="/transfer.do", produces = "text/html; charset=UTF-8")
	@ResponseBody //response.getWriter().append("transfer tranctionTest"); �� ���� ���̴�. 
	public String transactionTest() {
		aService.transfer();
		return "transfer tranctionTest";
	}
}
