package com.duong.ss09.service.hw01;

import com.duong.ss09.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface AuthService {
    Optional<Customer> findByUsername (String username);
}
