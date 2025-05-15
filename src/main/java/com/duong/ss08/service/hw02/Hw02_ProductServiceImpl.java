package com.duong.ss08.service.hw02;

import com.duong.ss08.repository.hw02.Hw02_ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Hw02_ProductServiceImpl implements Hw02_ProductService{
    @Autowired
    Hw02_ProductRepo hw02ProductRepo;

    @Override
    public List<String> getAllProduct() {
        return hw02ProductRepo.getAllProduct();
    }

    @Override
    public boolean addProduct(String product) {
        return hw02ProductRepo.addProduct(product);
    }
}
