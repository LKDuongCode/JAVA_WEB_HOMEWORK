package com.duong.ss05.service;
import com.duong.ss05.dao.UserDAO;
import com.duong.ss05.dao.UserDAOImpl;
import com.duong.ss05.model.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    private  final UserDAO userDAO = new UserDAOImpl();
    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }
}
