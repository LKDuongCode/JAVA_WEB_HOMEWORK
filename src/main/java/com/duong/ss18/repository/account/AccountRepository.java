package com.duong.ss18.repository.account;

import com.duong.ss18.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    List<Account> findAll();
    Optional<Account> findById(int id);
    List<Account> findAllWithPagination(int page, int size);
    List<Account> searchByUsername(String keyword, int page, int size);
    void update(Account account);
}
