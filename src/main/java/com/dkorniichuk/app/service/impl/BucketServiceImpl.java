package com.dkorniichuk.app.service.impl;

import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.service.BucketService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BucketServiceImpl implements BucketService {
    List<Product> bucket = new ArrayList<>();

    @Override
    public void add(Product product) {
        bucket.add(product);
    }

    @Override
    public void delete(Product product) {
        bucket.remove(product);
    }

    @Override
    public void clear() {
        bucket.clear();
    }

    public List<Product> get() {
        return bucket;
    }
}
