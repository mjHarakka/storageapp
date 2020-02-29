package com.mikkoharakka.fakebox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mikkoharakka.fakebox.repository.AccountRepository;

@Controller
public class ProfileController {
	
	@Autowired
	AccountRepository accountRepository;

	@GetMapping("/profile")
	public String getProfile(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		model.addAttribute("email", email);

		model.addAttribute("profile", accountRepository.findByEmail(email));
		return "profile";
	}
}
