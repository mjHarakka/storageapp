package com.mikkoharakka.fakebook.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@Autowired
	private HttpSession session;
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
	
	
}
