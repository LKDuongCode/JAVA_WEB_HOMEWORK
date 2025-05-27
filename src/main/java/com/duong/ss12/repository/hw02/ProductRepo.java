package com.duong.ss12.repository.hw02;

import com.duong.ss12.dto.hw02.CreateProductDTO;
import com.duong.ss12.dto.hw02.UpdateProductDTO;
import com.duong.ss12.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepo {
    List<Product> getAllProduct();
    boolean insertProduct (CreateProductDTO createProductDTO);
    boolean updateProduct (UpdateProductDTO updateProductDTO);
    boolean deleteProduct (int id);
    Optional<Product> findById (int id);
}
