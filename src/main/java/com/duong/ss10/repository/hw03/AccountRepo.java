package com.duong.ss10.repository.hw03;

import com.duong.ss10.model.Account;

import java.util.Optional;

public interface AccountRepo {
    Optional<Account> insertAccount (Account a);
}
