package com.dkorniichuk.imarket.service;

import com.dkorniichuk.imarket.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    public List<ProductCategory> getAllCategory();

    public ProductCategory getCategoryById(int id);

    public void save(ProductCategory category);
}
