package com.duong.ss16.service.hw01;

import com.duong.ss16.dto.hw01.LoginUserDTO;
import com.duong.ss16.dto.hw01.RegisterUserDTO;
import com.duong.ss16.model.hw01.User;

import java.util.Optional;

public interface UserService {
    boolean registerUser (RegisterUserDTO registerUserDTO);
    Optional<User> loginUser (LoginUserDTO loginUserDTO);
    Optional<User> findByEmail (String email);
}
