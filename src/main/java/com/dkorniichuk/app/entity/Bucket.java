package com.dkorniichuk.app.entity;


import java.util.ArrayList;
import java.util.List;

public class Bucket {
    List<Product> products = new ArrayList<>();
    private static Bucket INSTANCE;

    private Bucket() {
    }

    public void add(Product product) {
        products.add(product);
    }

    public void delete(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts(){
        return products;
    }

    public static Bucket getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Bucket();
        }
        return INSTANCE;
    }

}
