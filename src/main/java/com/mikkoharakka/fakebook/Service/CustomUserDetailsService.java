package com.mikkoharakka.fakebook.Service;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mikkoharakka.fakebook.model.Account;
import com.mikkoharakka.fakebook.repository.AccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account a = accountRepository.findByEmail(email);
        if (a == null) {
            throw new UsernameNotFoundException("No such email: " + email);
        }

        return new org.springframework.security.core.userdetails.User(
                a.getEmail(),
                a.getPassword(),
                true,
                true,
                true,
                true,
                Arrays.asList(new SimpleGrantedAuthority("USER")));
    }
}