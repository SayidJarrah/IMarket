package com.dkorniichuk.app.service;


import com.dkorniichuk.app.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public Product getProductById(int id);

    public void save(Product product);

    public Product binding(Product product);

    public List<Product> search(String keyword);

    public void update(Product product);

    public void delete(int productId);

    public void updateAmount(List<Product> products);
}
