package com.dkorniichuk.imarket.dao;


import com.dkorniichuk.imarket.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryDao {

    public List<ProductCategory> getAll();
    public ProductCategory getById(int id);
    public void save(ProductCategory category);

}
