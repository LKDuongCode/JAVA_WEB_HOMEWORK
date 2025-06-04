package com.duong.ss18.repository.order_detail;

import com.duong.ss18.entity.OrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface OrderDetailRepository {
    List<OrderDetail> findAll();
    Optional<OrderDetail> findById(int id);
    List<OrderDetail> findByBillId(int billId);
}
