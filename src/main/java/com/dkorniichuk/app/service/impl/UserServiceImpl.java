package com.dkorniichuk.app.service.impl;

import com.dkorniichuk.app.dao.UserDao;
import com.dkorniichuk.app.entity.User;
import com.dkorniichuk.app.entity.UserRole;
import com.dkorniichuk.app.service.UserService;
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
