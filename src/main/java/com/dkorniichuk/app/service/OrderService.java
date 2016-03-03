package com.dkorniichuk.app.service;


import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.entity.User;

import java.util.List;

public interface OrderService {

    public void add(List<Product> products,User user);
}
