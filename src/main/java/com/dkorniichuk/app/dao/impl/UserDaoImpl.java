package com.dkorniichuk.app.dao.impl;

import com.dkorniichuk.app.dao.UserDao;
import com.dkorniichuk.app.dao.util.UserRowMapper;
import com.dkorniichuk.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String SQL_SELECT_USER_BY_LOGIN = "SELECT * FROM USER WHERE login = ?";
    private static final String SQL_INSERT_NEW_USER = "INSERT INTO User (first_name,last_name,email,password,address,city,phone,registration_date,login,role) VALUES(?,?,?,?,?,?,?,?,?,?)";

    @Override
    public User getUser(String login) {
        return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_LOGIN, new Object[]{login}, new UserRowMapper());
    }

    @Override
    public void add(User user) {
        jdbcTemplate.update(SQL_INSERT_NEW_USER, new Object[]{
                user.getFirstName(),
                user.getSecondName(),
                user.getEmail(),
                user.getPassword(),
                user.getAddress(),
                user.getCity(),
                user.getPhone(),
                LocalDateTime.now(),
                user.getLogin(),
                user.getRole()});

    }
}
