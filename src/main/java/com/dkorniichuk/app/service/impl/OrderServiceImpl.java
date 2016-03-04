package com.dkorniichuk.app.service.impl;

import com.dkorniichuk.app.dao.OrderDao;
import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.entity.User;
import com.dkorniichuk.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;


    @Override
    public void add(List<Product> products, User user) {
            orderDao.add(products, user);

    }
}
