package com.mikkoharakka.fakebox.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mikkoharakka.fakebox.model.Account;

@Controller
public class DefaultController {
	
	@Autowired
	private HttpSession session;

	@GetMapping("/")
	public String getLandingPage() {

		if (session.getAttribute("SPRING_SECURITY_CONTEXT") != null) {
            return "redirect:/dashboard";
        }
		
		return "redirect:/dashboard";
	}
	
	
}
