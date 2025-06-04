package com.duong.ss18.service.bill;

import com.duong.ss18.entity.Bill;
import com.duong.ss18.entity.enums.BillStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BillService {
    List<Bill> filterBills(String username, String status, LocalDate from, LocalDate to, int page, int size);
    Optional<Bill> getBillById(int id);
    void updateStatus(int id, BillStatus newStatus);
}
