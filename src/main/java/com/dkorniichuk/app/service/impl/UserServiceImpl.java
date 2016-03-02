package com.dkorniichuk.app.service.impl;

import com.dkorniichuk.app.dao.impl.UserDaoImpl;
import com.dkorniichuk.app.entity.User;
import com.dkorniichuk.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserDaoImpl userDao;

    @Override
    public User getUser(String login) {
        return userDao.getUser(login);
    }
}
