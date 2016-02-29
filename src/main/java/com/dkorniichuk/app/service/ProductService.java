package com.dkorniichuk.app.service;


import com.dkorniichuk.app.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public Product getProductById(int id);

    public void save(Product product);

    public Product binding(Product product);
}
