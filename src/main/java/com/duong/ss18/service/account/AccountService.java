package com.duong.ss18.service.account;

import com.duong.ss18.entity.Account;
import com.duong.ss18.entity.enums.AccountStatus;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> getAllAccounts(int page, int size);
    List<Account> searchAccountsByUsername(String keyword, int page, int size);
    Optional<Account> getAccountById(int id);
    void updateAccountStatus(int id, AccountStatus newStatus);
}
