package com.dkorniichuk.app.dao;


import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.entity.User;

public interface OrderDao {
    public void add(Product product,User user);
}
