package com.duong.ss19.service.account;


import com.duong.ss19.dto.account.UpdateStatusAccountDTO;
import com.duong.ss19.entity.account.Account;
import com.duong.ss19.repository.account.AccountRepo;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService{
    private final AccountRepo accountRepo;

    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }


    @Override
    public Optional<Account> findById(int id) {
        return accountRepo.findById(id);
    }

    @Override
    public List<Account> findAllWithPagination(int page, int size) {
        return accountRepo.findAllWithPagination(page,size);
    }

    @Override
    public boolean update(UpdateStatusAccountDTO statusAccountDTO) {
        Account acc = new Account();
        acc.setId(statusAccountDTO.getId());
        acc.setStatus(statusAccountDTO.getStatus());
        return accountRepo.update(acc);
    }

    @Override
    public int countAccount() {
        return accountRepo.countAccount();
    }
}
