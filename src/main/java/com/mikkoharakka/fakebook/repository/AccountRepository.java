package com.mikkoharakka.fakebook.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mikkoharakka.fakebook.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByEmail(String email);

}
