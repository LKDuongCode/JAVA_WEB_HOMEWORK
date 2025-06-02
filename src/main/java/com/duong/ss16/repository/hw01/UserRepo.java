package com.duong.ss16.repository.hw01;

import com.duong.ss16.dto.hw01.LoginUserDTO;
import com.duong.ss16.dto.hw01.RegisterUserDTO;
import com.duong.ss16.model.hw01.User;

import java.util.Optional;

public interface UserRepo {
    boolean insertUser (RegisterUserDTO registerUserDTO);
    Optional<User> findUserByEmail (String email);
    Optional<User> findUserByEmailAndPassword (LoginUserDTO loginUserDTO);
}
