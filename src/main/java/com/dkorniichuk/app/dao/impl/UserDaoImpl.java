package com.dkorniichuk.app.dao.impl;

import com.dkorniichuk.app.dao.UserDao;
import com.dkorniichuk.app.dao.util.UserRowMapper;
import com.dkorniichuk.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String SQL_SELECT_USER_BY_LOGIN ="SELECT * FROM USER WHERE login = ?";

    @Override
    public User getUser(String login) {
        return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_LOGIN,new Object[]{login}, new UserRowMapper());
    }
}