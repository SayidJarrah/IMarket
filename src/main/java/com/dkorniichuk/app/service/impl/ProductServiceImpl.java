package com.dkorniichuk.app.service.impl;

import com.dkorniichuk.app.dao.impl.ProductDaoImpl;
import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDaoImpl productDao;

    public void setProductDao(ProductDaoImpl productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    @Override
    public Product getProductById(int id) {
        return productDao.getById(id);
    }

    @Override
    public void save(Product product) {
        System.out.println(product);
    }

}