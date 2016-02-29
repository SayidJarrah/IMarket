package com.dkorniichuk.app.dao.util;


import com.dkorniichuk.app.entity.ProductCategory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductCategoryRowMapper implements RowMapper<ProductCategory> {

    @Override
    public ProductCategory mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(resultSet.getInt("product_category_id"));
        productCategory.setName(resultSet.getString("category_name"));
        productCategory.setDescription(resultSet.getString("description"));
      //  productCategory.setAppearenceDate(resultSet.getTimestamp("appearence_date").toLocalDateTime());
        return productCategory;
    }
}
