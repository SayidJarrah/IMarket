package com.dkorniichuk.imarket.dao.util;


import com.dkorniichuk.imarket.dao.ProductDao;
import com.dkorniichuk.imarket.dao.UserDao;
import com.dkorniichuk.imarket.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ProductDao productDao;

    public OrderRowMapper(UserDao userDao, ProductDao productDao) {
        this.productDao = productDao;
        this.userDao = userDao;
    }

    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt("id_order"));
        order.setUser(userDao.getUser(resultSet.getString("login")));
        order.setProduct(productDao.getById(resultSet.getInt("id_product")));
        order.setPurchaseDate(resultSet.getTimestamp("order_date"));
        return order;
    }
}
