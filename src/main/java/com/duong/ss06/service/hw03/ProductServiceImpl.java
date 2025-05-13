package com.duong.ss06.service.hw03;

import com.duong.ss06.dao.hw03.ProductDao;
import com.duong.ss06.dao.hw03.ProductDaoImpl;
import com.duong.ss06.model.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }
}
