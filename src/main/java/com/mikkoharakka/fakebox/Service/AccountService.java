package com.mikkoharakka.fakebox.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikkoharakka.fakebox.model.Account;
import com.mikkoharakka.fakebox.model.FileObject;
import com.mikkoharakka.fakebox.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public Account getOneAccount(long id) {
		return accountRepository.getOne(id);
	}
	
	public Account getOneAccountWithEmail(String email) {
		return accountRepository.findByEmail(email);
	}
	
	
}
