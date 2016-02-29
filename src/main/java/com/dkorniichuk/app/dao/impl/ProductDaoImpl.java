package com.dkorniichuk.app.dao.impl;

import com.dkorniichuk.app.dao.ProductDao;
import com.dkorniichuk.app.dao.util.ProductRowMapper;
import com.dkorniichuk.app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ProductCategoryDaoImpl productCategoryDao;
    private static final String SQL_SELECT_ALL = "SELECT * FROM Product";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM Product WHERE id_product = ?";

    @Override
    public List<Product> getAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, new ProductRowMapper(productCategoryDao));
    }

    @Override
    public Product getById(int id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, new ProductRowMapper(productCategoryDao));
    }

    @Override
    public void save(Product product) {

    }


    public void setJdbcTemlate(JdbcTemplate jdbcTemlate) {
    }

    public void setProductCategoryDao(ProductCategoryDaoImpl productCategoryDao) {
    }
}
