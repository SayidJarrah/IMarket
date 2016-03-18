package com.dkorniichuk.imarket.service.impl;

import com.dkorniichuk.imarket.entity.Product;
import com.dkorniichuk.imarket.service.BucketService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BucketServiceImpl implements BucketService {
    private Map<String, List<Product>> map = new HashMap<>();

    @Override
    public void add(String login, Product product) {
        if (map.containsKey(login)) {
            for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
                if (login.equals(entry.getKey())) {
                    entry.getValue().add(product);
                }
            }
        } else {
            List<Product> products = new ArrayList<>();
            products.add(product);
            map.put(login, products);
        }
    }



    @Override
    public void delete(String login, Product product) {
        for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
            if (login.equals(entry.getKey())) {
                entry.getValue().remove(product);
            }
        }
    }

    @Override
    public void clear(String login) {
        for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
            if (login.equals(entry.getKey())) {
                entry.getValue().clear();
            }
        }
    }

    public List<Product> get(String login) {
        for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
            if (login.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

}