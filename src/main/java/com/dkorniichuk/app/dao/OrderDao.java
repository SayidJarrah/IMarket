package com.dkorniichuk.app.dao;


import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.entity.User;

import java.util.List;

public interface OrderDao {
    public void add(List<Product> products,User user);
}
