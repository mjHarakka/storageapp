package com.mikkoharakka.fakebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String redirectLogout() {
		return "redirect:/";
	}
}
