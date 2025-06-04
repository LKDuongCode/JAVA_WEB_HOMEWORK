package com.duong.ss18.service.product;

import com.duong.ss18.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getAllProductsWithPagination(int page, int size);
    Optional<Product> getProductById(int id);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
}
