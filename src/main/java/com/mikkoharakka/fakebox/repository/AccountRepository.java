package com.mikkoharakka.fakebox.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mikkoharakka.fakebox.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByEmail(String email);

}
