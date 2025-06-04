package com.duong.ss18.service.account;

import com.duong.ss18.entity.Account;
import com.duong.ss18.entity.enums.AccountStatus;
import com.duong.ss18.repository.account.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccounts(int page, int size) {
        return accountRepository.findAllWithPagination(page, size);
    }

    @Override
    public List<Account> searchAccountsByUsername(String keyword, int page, int size) {
        return accountRepository.searchByUsername(keyword, page, size);
    }

    @Override
    public Optional<Account> getAccountById(int id) {
        return accountRepository.findById(id);
    }

    @Override
    public void updateAccountStatus(int id, AccountStatus newStatus) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        optionalAccount.ifPresent(account -> {
            account.setStatus(newStatus);
            accountRepository.update(account);
        });
    }
}
