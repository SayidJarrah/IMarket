package com.dkorniichuk.imarket.service;


import com.dkorniichuk.imarket.entity.Product;

import java.util.List;

public interface BucketService {
    public void add(String login, Product product);

    public void delete(String login, Product product);

    public void clear(String login);

    public List<Product> get(String login);

}