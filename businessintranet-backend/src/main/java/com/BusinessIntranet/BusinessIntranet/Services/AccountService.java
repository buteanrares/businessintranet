package com.BusinessIntranet.BusinessIntranet.Services;

import com.BusinessIntranet.BusinessIntranet.Exceptions.AccountNotFoundException;
import com.BusinessIntranet.BusinessIntranet.Models.Account;
import com.BusinessIntranet.BusinessIntranet.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = this.accountRepository.findAccountByEmail(email)
                .orElseThrow(() -> new AccountNotFoundException("Account with email " + email + " does not exist."));
        return new User(account.getEmail(), account.getPassword(), new ArrayList<>()); // TODO: Define roles
    }

    public Account createAccount(Account account) {
        return this.accountRepository.save(account);
    }

    public List<Account> findAllAccounts() {
        return this.accountRepository.findAll();
    }

    public Account findAccountById(Long id) {
        return this.accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account with id " + id + " does not exist."));
    }

    public Account findAccountByEmail(String email) {
        return this.accountRepository.findAccountByEmail(email)
                .orElseThrow(() -> new AccountNotFoundException("Account with email " + email + "does not exist."));
    }

    public Account updateAccount(Account account) {
        return this.accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        this.accountRepository.deleteById(id);
    }

}
