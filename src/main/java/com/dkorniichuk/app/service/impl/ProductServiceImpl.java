package com.dkorniichuk.app.service.impl;

import com.dkorniichuk.app.dao.ProductDao;
import com.dkorniichuk.app.dao.impl.ProductDaoImpl;
import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.service.ProductCategoryService;
import com.dkorniichuk.app.service.ProductService;
import com.dkorniichuk.app.service.util.PriceComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductCategoryService categoryService;

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
        productDao.save(product);
    }

    @Override
    public Product binding(Product product) {
        product.setCategory(categoryService.getCategoryById(product.getId()));
        product.setAppearanceDate(LocalDateTime.now());
        product.setLastModifiedDate(LocalDateTime.now());
        return product;
    }

    @Override
    public List<Product> search(String keyString) {
        return productDao.search(keyString);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delete(int productId) {
        productDao.delete(productId);
    }

    @Override
    public void updateAmount(List<Product> products) {
        for (Product product : products) {
            productDao.updateAmount(product);
        }
    }

    @Override
    public List<Product> sortByPriceAsc(List<Product> products) {
        Collections.sort(products, new PriceComparator());
        return products;
    }

    @Override
    public List<Product> sortByPriceDesc(List<Product> products) {
        Collections.sort(products, new PriceComparator().reversed());
        return products;
    }


}