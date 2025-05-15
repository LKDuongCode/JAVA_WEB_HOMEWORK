package com.duong.ss08.repository.hw02;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Hw02_ProductRepoImpl implements Hw02_ProductRepo{
    private static List<String> products = new ArrayList<>();
    @Override
    public List<String> getAllProduct() {
        if (products.isEmpty()) {
            products.add("laptop");
            products.add("iphone");
            products.add("samsung");
            products.add("airpods");
        }
        return products;
    }

    @Override
    public boolean addProduct(String product) {
        return products.add(product);
    }
}
