package com.dkorniichuk.app.service.util;

import com.dkorniichuk.app.entity.Product;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }

}