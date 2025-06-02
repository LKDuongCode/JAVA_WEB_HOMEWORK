package com.duong.ss16.service.hw01;

import com.duong.ss16.dto.hw01.LoginUserDTO;
import com.duong.ss16.dto.hw01.RegisterUserDTO;
import com.duong.ss16.model.hw01.User;
import com.duong.ss16.repository.hw01.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public boolean registerUser(RegisterUserDTO registerUserDTO) {
        if(userRepo.insertUser(registerUserDTO)){
            System.out.println("Register success!");
            return true;
        }
        System.out.println("Register failed!");
        return false;
    }

    @Override
    public Optional<User> loginUser(LoginUserDTO loginUserDTO) {
        return userRepo.findUserByEmailAndPassword(loginUserDTO);
    }


    @Override
    public Optional<User> findByEmail(String email) {

        return userRepo.findUserByEmail(email);
    }
}
