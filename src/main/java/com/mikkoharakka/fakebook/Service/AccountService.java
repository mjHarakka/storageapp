package com.mikkoharakka.fakebook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikkoharakka.fakebook.model.Account;
import com.mikkoharakka.fakebook.model.FileObject;
import com.mikkoharakka.fakebook.repository.AccountRepository;

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
