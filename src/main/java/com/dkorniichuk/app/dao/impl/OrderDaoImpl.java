package com.dkorniichuk.app.dao.impl;

import com.dkorniichuk.app.dao.OrderDao;
import com.dkorniichuk.app.dao.util.ActualOrderToBucketIdGenerator;
import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ActualOrderToBucketIdGenerator generator;
    private static final String SQL_INSERT_NEW_ORDER = "INSERT INTO IMarket.order (id_order,id_user) VALUES(?,?)";
    private static final String SQL_INSERT_NEW_BUCKET = "INSERT INTO bucket (id_order,id_product) VALUES(?,?)";

    @Override
    public void add(List<Product> products, User user) {
        int id = generator.getActualOrderId();
        jdbcTemplate.update(SQL_INSERT_NEW_ORDER, new Object[]{id, user.getId()});
        for (Product product : products) {
            jdbcTemplate.update(SQL_INSERT_NEW_BUCKET, new Object[]{id, product.getId()});
        }
    }
}
