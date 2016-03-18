package com.dkorniichuk.imarket.dao;


import com.dkorniichuk.imarket.entity.Order;
import com.dkorniichuk.imarket.entity.Product;
import com.dkorniichuk.imarket.entity.User;

import java.util.List;

public interface OrderDao {
    public void add(List<Product> products,User user);

    public List<Order> getByUser(User user);

    public List<Order> getByProduct(Product product);
}
