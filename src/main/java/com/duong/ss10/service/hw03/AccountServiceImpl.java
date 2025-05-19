package com.duong.ss10.service.hw03;

import com.duong.ss10.model.Account;
import com.duong.ss10.repository.hw03.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{
    // constructor injection được recommend
    private final AccountRepo accountRepo;

    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public Optional<Account> addAccount(Account a) {
        return accountRepo.insertAccount(a);
    }
}
