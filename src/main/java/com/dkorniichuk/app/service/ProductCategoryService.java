package com.dkorniichuk.app.service;

import com.dkorniichuk.app.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    public List<ProductCategory> getAllCategory();

    public ProductCategory getCategoryById(int id);

    public void save(ProductCategory category);
}
