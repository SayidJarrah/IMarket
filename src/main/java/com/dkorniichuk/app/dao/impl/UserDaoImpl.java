package com.dkorniichuk.app.dao.impl;

import com.dkorniichuk.app.dao.UserDao;
import com.dkorniichuk.app.dao.util.UserRowMapper;
import com.dkorniichuk.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String SELECT_USER_BY_LOGIN_SQL = "SELECT * FROM USER WHERE login = ?";
    private static final String INSERT_NEW_USER_SQL = "INSERT INTO User (first_name,last_name,email,password,address,city,phone,registration_date,login,role) VALUES(?,?,?,?,?,?,?,?,?,?)";

    @Override
    public User getUser(String login) {
        return jdbcTemplate.queryForObject(SELECT_USER_BY_LOGIN_SQL, new Object[]{login}, new UserRowMapper());
    }

    @Override
    public void add(User user) {
        jdbcTemplate.update(INSERT_NEW_USER_SQL,
                user.getFirstName(),
                user.getSecondName(),
                user.getEmail(),
                user.getPassword(),
                user.getAddress(),
                user.getCity(),
                user.getPhone(),
                LocalDateTime.now(),
                user.getLogin(),
                user.getRole());

    }
}
