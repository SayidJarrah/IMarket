package com.dkorniichuk.app.dao.impl;

import com.dkorniichuk.app.dao.ProductCategoryDao;
import com.dkorniichuk.app.dao.ProductDao;
import com.dkorniichuk.app.dao.util.ProductRowMapper;
import com.dkorniichuk.app.dao.util.SqlSearchQueryGenerator;
import com.dkorniichuk.app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ProductCategoryDao productCategoryDao;
    @Autowired
    private SqlSearchQueryGenerator generator;

    private static final String SELECT_ALL_SQL = "SELECT * FROM Product";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM Product WHERE id_product = ?";
    private static final String INSERT_NEW_PRODUCT_SQL = "INSERT INTO Product (id_product_category,product_name,product_price,product_image,product_description,appearance_date,available_amount) VALUES(?,?,?,?,?,?,?)";
    private static final String UPDATE_SQL = "UPDATE Product SET product_name= ?, product_price = ?, product_description = ?, available_amount = ? WHERE id_product = ? ";
    private static final String DELETE_SQL = "DELETE FROM Product WHERE id_product = ?";
    private static final String UPDATE_AMOUNT_SQL = "UPDATE Product SET available_amount = ? WHERE id_product = ? ";


    @Override
    public List<Product> getAll() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new ProductRowMapper(productCategoryDao));
    }

    @Override
    public Product getById(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new Object[]{id}, new ProductRowMapper(productCategoryDao));
    }

    @Override
    public void save(Product product) {
        jdbcTemplate.update(INSERT_NEW_PRODUCT_SQL,
                product.getCategory().getId(),
                product.getName(),
                product.getPrice(),
                product.getImage(),
                product.getDescription(),
                product.getAppearanceDate(),
                product.getAvailableAmount());
    }

    @Override
    public List<Product> search(String keyWord) {
        return jdbcTemplate.query(generator.generateQuery(keyWord), new ProductRowMapper(productCategoryDao));
    }

    @Override
    public void update(Product product) {
        jdbcTemplate.update(UPDATE_SQL, product.getName(), product.getPrice(), product.getDescription(), product.getAvailableAmount(), product.getId());

    }

    @Override
    public void delete(int productId) {
        jdbcTemplate.update(DELETE_SQL, productId);
    }

    @Override
    public void updateAmount(Product product) {
        jdbcTemplate.update(UPDATE_AMOUNT_SQL, product.getAvailableAmount() - 1, product.getId());
    }
}
