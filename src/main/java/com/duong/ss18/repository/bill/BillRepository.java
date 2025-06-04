package com.duong.ss18.repository.bill;

import com.duong.ss18.entity.Bill;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BillRepository {
    List<Bill> findAll();
    Optional<Bill> findById(int id);
    List<Bill> findByAccountId(int accountId);

    List<Bill> filter(String username, String status, LocalDate from, LocalDate to, int page, int size);
    void update(Bill bill);
}
