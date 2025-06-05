package com.duong.ss19.service.account;


import com.duong.ss19.dto.account.UpdateStatusAccountDTO;
import com.duong.ss19.entity.account.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Optional<Account> findById(int id);
    List<Account> findAllWithPagination(int page, int size);
    boolean update(UpdateStatusAccountDTO statusAccountDTO);
    int countAccount();
}
