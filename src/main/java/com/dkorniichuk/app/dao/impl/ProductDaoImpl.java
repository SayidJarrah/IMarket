package com.dkorniichuk.app.dao.impl;

import com.dkorniichuk.app.dao.ProductDao;
import com.dkorniichuk.app.dao.util.ProductRowMapper;
import com.dkorniichuk.app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ProductDaoImpl implements ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String SQL_SELECT_ALL = "SELECT * FROM Product";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM Product WHERE id_product = ?";

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_SELECT_ALL);

        for (Map<String, Object> row : rows) {     //TODO: use RowMapper
            Product product = new Product();
            product.setId((Integer) row.get("id_product"));
            //   product.setCategoryId((Integer) row.get("id_product_category"));
            product.setName((String) row.get("product_name"));
            product.setPrice((Double) row.get("product_price"));
            product.setImage((byte[]) row.get("product_image"));
            product.setDescription((String) row.get("product_description"));
            product.setAppearanceDate(((Timestamp) row.get("appearance_date")).toLocalDateTime());
            product.setAvailableAmount((Integer) row.get("available_amount"));
            product.setLastModifiedDate(((Timestamp) row.get("last_modified")).toLocalDateTime());
            products.add(product);
        }
        return products;
    }

    @Override
    public Product getById(int id) {
        Product product = (Product) jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, new ProductRowMapper());
        return product;
    }


    public void setJdbcTemlate(JdbcTemplate jdbcTemlate) {
    }
}
