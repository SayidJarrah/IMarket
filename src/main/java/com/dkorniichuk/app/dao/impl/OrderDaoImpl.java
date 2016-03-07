package com.dkorniichuk.app.dao.impl;

import com.dkorniichuk.app.dao.OrderDao;
import com.dkorniichuk.app.dao.util.ActualOrderToBucketIdGenerator;
import com.dkorniichuk.app.dao.util.OrderRowMapper;
import com.dkorniichuk.app.entity.Order;
import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ActualOrderToBucketIdGenerator generator;
    @Autowired
    private UserDaoImpl userDao;
    @Autowired
    private ProductDaoImpl productDao;

    private static final String SQL_INSERT_NEW_ORDER = "INSERT INTO IMarket.order (id_order,id_user,order_date) VALUES(?,?,?)";
    private static final String SQL_INSERT_NEW_BUCKET = "INSERT INTO bucket (id_order,id_product) VALUES(?,?)";
    private static final String SQL_FOR_HISTORY = " SELECT * FROM imarket.user us" +
            "    JOIN imarket.order ord" +
            "    ON us.id_user=ord.id_user" +
            "    JOIN imarket.bucket bu" +
            "    ON bu.id_order = ord.id_order" +
            "    JOIN imarket.product pr" +
            "    ON pr.id_product=bu.id_product" +
            "    WHERE us.login = ?";

    @Override
    public void add(List<Product> products, User user) {
        int id = generator.getActualOrderId();
        jdbcTemplate.update(SQL_INSERT_NEW_ORDER, new Object[]{id, user.getId(), LocalDateTime.now()});
        for (Product product : products) {
            jdbcTemplate.update(SQL_INSERT_NEW_BUCKET, new Object[]{id, product.getId()});
        }
    }

    @Override
    public List<Order> getByUser(User user) {
        return jdbcTemplate.query(SQL_FOR_HISTORY, new Object[]{user.getLogin()}, new OrderRowMapper(userDao, productDao));
    }

    @Override
    public List<Order> getByProduct(Product product) {
        return null;
    }
}
