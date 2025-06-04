package com.duong.ss18.service.bill;

import com.duong.ss18.entity.Bill;
import com.duong.ss18.entity.enums.BillStatus;
import com.duong.ss18.repository.bill.BillRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public List<Bill> filterBills(String username, String status, LocalDate from, LocalDate to, int page, int size) {
        return billRepository.filter(username, status, from, to, page, size);
    }

    @Override
    public Optional<Bill> getBillById(int id) {
        return billRepository.findById(id);
    }

    @Override
    public void updateStatus(int id, BillStatus newStatus) {
        Optional<Bill> optional = billRepository.findById(id);
        optional.ifPresent(bill -> {
            bill.setStatus(newStatus);
            billRepository.update(bill);
        });
    }
}
