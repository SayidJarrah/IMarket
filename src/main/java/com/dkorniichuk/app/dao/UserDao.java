package com.dkorniichuk.app.dao;


import com.dkorniichuk.app.entity.User;

public interface UserDao {

    public User getUser(String login);

    public void add(User user);
}
