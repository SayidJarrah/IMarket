package com.dkorniichuk.app.service;


import com.dkorniichuk.app.entity.User;

public interface UserService {

    public User get(String login);

    public void add(User user);
}
