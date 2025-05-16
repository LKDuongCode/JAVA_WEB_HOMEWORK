package com.duong.ss09.service.hw01;

import com.duong.ss09.model.Customer;
import com.duong.ss09.repository.hw01.AuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    AuthenticationRepo authenticationRepo;

    @Override
    public Optional<Customer> findByUsername(String username) {
        return authenticationRepo.findByUsername(username);
    }
}
