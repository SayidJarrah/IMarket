package com.dkorniichuk.app.dao;


import com.dkorniichuk.app.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryDao {

    public List<ProductCategory> getAll();
    public ProductCategory getById(int id);

}
