package com.dkorniichuk.imarket.dao.impl;

import com.dkorniichuk.imarket.dao.OrderDao;
import com.dkorniichuk.imarket.dao.ProductDao;
import com.dkorniichuk.imarket.dao.UserDao;
import com.dkorniichuk.imarket.dao.util.OrderToBucketIdGenerator;
import com.dkorniichuk.imarket.dao.util.OrderRowMapper;
import com.dkorniichuk.imarket.entity.Order;
import com.dkorniichuk.imarket.entity.Product;
import com.dkorniichuk.imarket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private OrderToBucketIdGenerator generator;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ProductDao productDao;

    private static final String INSERT_NEW_ORDER_SQL = "INSERT INTO IMarket.order (id_order,id_user,order_date) VALUES(?,?,?)";
    private static final String INSERT_NEW_BUCKET_SQL = "INSERT INTO bucket (id_order,id_product) VALUES(?,?)";
    private static final String FOR_HISTORY_SQL = " SELECT * FROM imarket.user us" +
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
        jdbcTemplate.update(INSERT_NEW_ORDER_SQL, id, user.getId(), LocalDateTime.now());
        for (Product product : products) {
            jdbcTemplate.update(INSERT_NEW_BUCKET_SQL, id, product.getId());
        }
    }

    @Override
    public List<Order> getByUser(User user) {
        return jdbcTemplate.query(FOR_HISTORY_SQL, new Object[]{user.getLogin()}, new OrderRowMapper(userDao, productDao));
    }

    @Override
    public List<Order> getByProduct(Product product) {
        return null;
    }
}
