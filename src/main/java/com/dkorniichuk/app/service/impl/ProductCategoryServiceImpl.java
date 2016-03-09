package com.dkorniichuk.app.service.impl;


import com.dkorniichuk.app.dao.ProductCategoryDao;
import com.dkorniichuk.app.entity.ProductCategory;
import com.dkorniichuk.app.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao categoryDao;

    @Override
    public List<ProductCategory> getAllCategory() {
        return categoryDao.getAll();
    }

    @Override
    public ProductCategory getCategoryById(int id) {
        return categoryDao.getById(id);
    }

    @Override
    public void save(ProductCategory category) {
        category.setAppearenceDate(LocalDateTime.now());
        categoryDao.save(category);
    }
}
