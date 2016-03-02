package com.dkorniichuk.app.dao.impl;

import com.dkorniichuk.app.dao.ProductDao;
import com.dkorniichuk.app.dao.util.ProductRowMapper;
import com.dkorniichuk.app.dao.util.SqlSearchQueryGenerator;
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
    @Autowired
    private SqlSearchQueryGenerator generator;
    private static final String SQL_SELECT_ALL = "SELECT * FROM Product";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM Product WHERE id_product = ?";
    private static final String SQL_INSERT_NEW_PRODUCT = "INSERT INTO Product (id_product_category,product_name,product_price,product_image,product_description,appearance_date,available_amount) VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Product SET product_name= ?, product_price = ?, product_description = ?, available_amount = ? WHERE id_product = ? ";
    private static final String SQL_DELETE = "DELETE FROM Product WHERE id_product = ?";


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
        jdbcTemplate.update(SQL_INSERT_NEW_PRODUCT, new Object[]{
                product.getCategory().getId(),
                product.getName(),
                product.getPrice(),
                product.getImage(),
                product.getDescription(),
                product.getAppearanceDate(),
                product.getAvailableAmount()});
    }

    @Override
    public List<Product> search(String keyWord) {
        return jdbcTemplate.query(generator.generateQuery(keyWord), new ProductRowMapper(productCategoryDao));
    }

    @Override
    public void update(Product product) {
        jdbcTemplate.update(SQL_UPDATE, new Object[]{product.getName(), product.getPrice(), product.getDescription(), product.getAvailableAmount(), product.getId()});

    }

    @Override
    public void delete(int productId) {
       jdbcTemplate.update(SQL_DELETE,new Object[]{productId});
    }
}
