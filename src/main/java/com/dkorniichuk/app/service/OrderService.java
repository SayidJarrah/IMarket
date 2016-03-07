package com.dkorniichuk.app.service;


import com.dkorniichuk.app.entity.Order;
import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.entity.User;

import java.util.List;

public interface OrderService {

    public void add(List<Product> products,User user);

    public List<Order> getByUser(User user);

    public List<Order> getByProduct(Product product);  // for administrative purposes
}
