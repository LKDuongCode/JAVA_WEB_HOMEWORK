package com.duong.ss06.dao.hw01_02;

import com.duong.ss06.model.User;

import java.util.Optional;

public interface UserDAO {
    Optional<User> findByEmail (String email);
    public boolean save(User user);
}
