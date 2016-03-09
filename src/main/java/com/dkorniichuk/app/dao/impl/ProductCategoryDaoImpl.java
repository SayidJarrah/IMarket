package com.dkorniichuk.app.dao.impl;

import com.dkorniichuk.app.dao.ProductCategoryDao;
import com.dkorniichuk.app.dao.util.ProductCategoryRowMapper;
import com.dkorniichuk.app.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductCategoryDaoImpl implements ProductCategoryDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String SELECT_ALL_SQL = "SELECT * FROM product_category";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM product_category WHERE product_category_id = ?";
    private static final String INSERT_NEW_CATEGORY_SQL = "INSERT INTO Product_category (category_name, description,appearence_date) VALUES(?,?,?)";


    @Override
    public List<ProductCategory> getAll() {
        return jdbcTemplate.query(SELECT_ALL_SQL,new ProductCategoryRowMapper());
    }

    @Override
    public ProductCategory getById(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new Object[]{id}, new ProductCategoryRowMapper());
    }

    @Override
    public void save(ProductCategory category) {
        jdbcTemplate.update(INSERT_NEW_CATEGORY_SQL,category.getName(),category.getDescription(),category.getAppearanceDate());
    }
}
