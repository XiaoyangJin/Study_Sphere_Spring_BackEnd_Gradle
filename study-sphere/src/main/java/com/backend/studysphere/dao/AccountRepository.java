package com.backend.studysphere.dao;

import com.backend.studysphere.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
