package com.backend.studysphere.rest;

import com.backend.studysphere.dao.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
}
