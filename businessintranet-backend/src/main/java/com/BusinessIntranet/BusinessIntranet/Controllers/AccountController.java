package com.BusinessIntranet.BusinessIntranet.Controllers;

import com.BusinessIntranet.BusinessIntranet.Models.Account;
import com.BusinessIntranet.BusinessIntranet.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = this.accountService.findAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") Long id) {
        Account account = this.accountService.findAccountById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account newAccount = this.accountService.createAccount(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        Account updateAccount = this.accountService.updateAccount(account);
        return new ResponseEntity<>(updateAccount, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("id") Long id) {
        this.accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
