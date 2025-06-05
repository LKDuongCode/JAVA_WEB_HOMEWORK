package com.duong.ss19.repository.account;


import com.duong.ss19.entity.account.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepo {
    Optional<Account> findById(int id);
    List<Account> findAllWithPagination(int page, int size);
    boolean update(Account account);
     int countAccount();
}
