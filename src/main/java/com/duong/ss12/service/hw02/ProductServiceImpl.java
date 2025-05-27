package com.duong.ss12.service.hw02;

import com.duong.ss12.dto.hw02.CreateProductDTO;
import com.duong.ss12.dto.hw02.UpdateProductDTO;
import com.duong.ss12.model.Product;
import com.duong.ss12.repository.hw02.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.getAllProduct();
    }

    @Override
    public boolean insertProduct(CreateProductDTO createProductDTO) {
        return productRepo.insertProduct(createProductDTO);
    }

    @Override
    public boolean updateProduct(UpdateProductDTO updateProductDTO) {
        return productRepo.updateProduct(updateProductDTO);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productRepo.deleteProduct(id);
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepo.findById(id);
    }
}
