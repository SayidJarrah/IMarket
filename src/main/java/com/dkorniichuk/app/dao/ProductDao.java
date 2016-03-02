package com.dkorniichuk.app.dao;


import com.dkorniichuk.app.entity.Product;

import java.util.List;

public interface ProductDao {

    public List<Product> getAll();

    public Product getById(int id);

    public void save(Product product);

    public List<Product> search(String keyWord);

    public void update(Product product);

    public void delete(int productId);

}
