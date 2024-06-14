package com.backend.studysphere.rest;

import com.backend.studysphere.dao.AccountRepository;
import com.backend.studysphere.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        account.setLastLoginTime(OffsetDateTime.now()); // Setting the last login time at account creation
        Account savedAccount = accountRepository.save(account);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable long id) {
        return accountRepository.findById(id)
                .map(account -> new ResponseEntity<>(account, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable long id, @RequestBody Account accountDetails) {
        return accountRepository.findById(id).map(account -> {
            account.setUsername(accountDetails.getUsername());
            account.setPassword(accountDetails.getPassword());
            account.setLastLoginTime(accountDetails.getLastLoginTime());
            Account updatedAccount = accountRepository.save(account);
            return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
