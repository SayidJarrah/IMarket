package com.dkorniichuk.app.service;


import com.dkorniichuk.app.entity.Product;

import java.util.List;

public interface BucketService {
    public void add(Product product);

    public void delete(Product product);

    public void clear();

    public List<Product> get();

}