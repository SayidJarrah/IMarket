package com.dkorniichuk.imarket.dao.util;

import com.dkorniichuk.imarket.dao.ProductCategoryDao;
import com.dkorniichuk.imarket.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product>{
@Autowired
    private ProductCategoryDao productCategoryDao;

    public ProductRowMapper(ProductCategoryDao productCategoryDao) {
        this.productCategoryDao = productCategoryDao;
    }

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt("id_product"));
        product.setCategory(productCategoryDao.getById(resultSet.getInt("id_product_category")));
        product.setName(resultSet.getString("product_name"));
        product.setPrice(resultSet.getDouble("product_price"));
        product.setImage(resultSet.getBytes("product_image"));
        product.setDescription(resultSet.getString("product_description"));
        product.setAppearanceDate(resultSet.getTimestamp("appearance_date").toLocalDateTime());
        product.setAvailableAmount(resultSet.getInt("available_amount"));
        return product;
    }

}

