package com.dkorniichuk.app.dao.impl;

import com.dkorniichuk.app.dao.OrderDao;
import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderDaoImpl implements OrderDao {
    private static int idCounter;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String SQL_INSERT_NEW_ORDER = "INSERT INTO order (id_order,id_user,order_date) VALUES(?,?,sysdate())";
    private static final String SQL_INSERT_NEW_BUCKET = "INSERT INTO bucket (id_bucket,id_order,id_product) VALUES(?,?,?)";

    @Override
    public void add(Product product, User user) {
        jdbcTemplate.update(SQL_INSERT_NEW_ORDER, new Object[]{idCounter, user.getId()});
        jdbcTemplate.update(SQL_INSERT_NEW_BUCKET, new Object[]{idCounter, product.getId()});
        idCounter++;
    }
}
