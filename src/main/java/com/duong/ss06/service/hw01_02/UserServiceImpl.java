package com.duong.ss06.service.hw01_02;

import com.duong.ss06.dao.hw01_02.UserDAO;
import com.duong.ss06.dao.hw01_02.UserDaoImpl;
import com.duong.ss06.model.User;

import java.util.Optional;

public class UserServiceImpl implements UserService{
    private final UserDAO userDAO = new UserDaoImpl();

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Override
    public boolean createUser(User user) {
        return userDAO.save(user);
    }

}
