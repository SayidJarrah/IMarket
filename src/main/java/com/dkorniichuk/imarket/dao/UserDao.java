package com.dkorniichuk.imarket.dao;


import com.dkorniichuk.imarket.entity.User;

public interface UserDao {

    public User getUser(String login);

    public void add(User user);
}
