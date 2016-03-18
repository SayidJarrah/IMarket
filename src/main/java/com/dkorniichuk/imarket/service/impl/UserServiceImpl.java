package com.dkorniichuk.imarket.service.impl;

import com.dkorniichuk.imarket.dao.UserDao;
import com.dkorniichuk.imarket.entity.User;
import com.dkorniichuk.imarket.entity.UserRole;
import com.dkorniichuk.imarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User get(String login) {
        return userDao.getUser(login);
    }

    @Override
    public void add(User user) {
        user.setRole(UserRole.ROLE_USER);
        userDao.add(user);
    }
}
