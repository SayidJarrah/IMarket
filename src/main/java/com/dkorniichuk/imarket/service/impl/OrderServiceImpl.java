package com.dkorniichuk.imarket.service.impl;

import com.dkorniichuk.imarket.dao.OrderDao;
import com.dkorniichuk.imarket.entity.Order;
import com.dkorniichuk.imarket.entity.Product;
import com.dkorniichuk.imarket.entity.User;
import com.dkorniichuk.imarket.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;


    @Override
    public void add(List<Product> products, User user) {
            orderDao.add(products, user);

    }

    @Override
    public List<Order> getByUser(User user) {
        return orderDao.getByUser(user);
    }

    @Override
    public List<Order> getByProduct(Product product) {
        return null;
    }
}
