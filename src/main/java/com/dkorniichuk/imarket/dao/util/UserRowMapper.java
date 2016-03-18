package com.dkorniichuk.imarket.dao.util;

import com.dkorniichuk.imarket.entity.User;
import com.dkorniichuk.imarket.entity.UserRole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id_user"));
        user.setLogin(resultSet.getString("login"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setSecondName(resultSet.getString("last_name"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setAddress(resultSet.getString("address"));
        user.setCity(resultSet.getString("city"));
        user.setPhone(resultSet.getString("phone"));
        user.setRegistrationDate(resultSet.getTimestamp("registration_date"));
        user.setRole(UserRole.valueOf(resultSet.getString("role")));
        return user;
    }
}
