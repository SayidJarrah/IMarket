package com.dkorniichuk.app.dao.impl;

import com.dkorniichuk.app.dao.ProductCategoryDao;
import com.dkorniichuk.app.dao.util.ProductCategoryRowMapper;
import com.dkorniichuk.app.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductCategoryDaoImpl implements ProductCategoryDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String SQL_SELECT_ALL = "SELECT * FROM product_category";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM product_category WHERE product_category_id = ?";
    private static final String SQL_INSERT_NEW_CATEGORY = "INSERT INTO Product_category (category_name, description,appearence_date) VALUES(?,?,?)";


    @Override
    public List<ProductCategory> getAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL,new ProductCategoryRowMapper());
    }

    @Override
    public ProductCategory getById(int id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, new ProductCategoryRowMapper());
    }

    @Override
    public void save(ProductCategory category) {
        jdbcTemplate.update(SQL_INSERT_NEW_CATEGORY,new Object[]{category.getName(),category.getDescription(),category.getAppearanceDate()});
    }
}
