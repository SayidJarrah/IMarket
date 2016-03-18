package com.dkorniichuk.imarket.service;


import com.dkorniichuk.imarket.entity.User;

public interface UserService {

    public User get(String login);

    public void add(User user);
}
