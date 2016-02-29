package com.dkorniichuk.app.service.impl;


import com.dkorniichuk.app.dao.impl.ProductCategoryDaoImpl;
import com.dkorniichuk.app.entity.ProductCategory;
import com.dkorniichuk.app.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryDaoImpl categoryDao;
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

    }
}
