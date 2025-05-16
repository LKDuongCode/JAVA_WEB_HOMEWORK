package com.duong.ss09.repository.hw01;

import com.duong.ss09.model.Customer;

import java.util.Optional;

public interface AuthenticationRepo {
    Optional<Customer> findByUsername (String username);
}
