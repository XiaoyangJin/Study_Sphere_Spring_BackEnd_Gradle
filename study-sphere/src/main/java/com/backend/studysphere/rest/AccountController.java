package com.backend.studysphere.rest;

import com.backend.studysphere.dao.AccountRepository;
import com.backend.studysphere.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

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
}
