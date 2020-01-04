package com.mikkoharakka.fakebook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mikkoharakka.fakebook.model.Account;
import com.mikkoharakka.fakebook.repository.AccountRepository;

@Controller
public class RegisterController {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/register")
	public String getRegister(Model model) {
		model.addAttribute("user", new Account());
		return "register";
	}

	@PostMapping("/register")
    public String add(Account u) {
		String email = u.getEmail();

        if (accountRepository.findByEmail(email) != null) {
            return "redirect:/";
        }
        
        String firstName = u.getFirstName();
        String lastName = u.getLastName();
        String password = u.getPassword();
        
        Account a = new Account(email, passwordEncoder.encode(password), firstName, lastName, null);
        accountRepository.save(a);
        return "redirect:/";
    }
	
}
