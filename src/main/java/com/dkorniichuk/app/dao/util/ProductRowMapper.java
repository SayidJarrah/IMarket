package com.dkorniichuk.app.dao.util;

import com.dkorniichuk.app.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper{
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt("id_product"));
        product.setName(resultSet.getString("product_name"));
        product.setPrice(resultSet.getDouble("product_price"));
        product.setImage(resultSet.getBytes("product_image"));
        product.setDescription(resultSet.getString("product_description"));
        product.setAppearanceDate(resultSet.getTimestamp("appearance_date").toLocalDateTime());
        product.setAvailableAmount(resultSet.getInt("available_amount"));
        product.setLastModifiedDate(resultSet.getTimestamp("last_modified").toLocalDateTime());
        return product;
    }
}

