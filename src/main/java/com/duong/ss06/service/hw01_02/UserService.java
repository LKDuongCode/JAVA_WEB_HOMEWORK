package com.duong.ss06.service.hw01_02;

import com.duong.ss06.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserByEmail (String email);
    boolean createUser(User user);
}
