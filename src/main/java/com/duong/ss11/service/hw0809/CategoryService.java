package com.duong.ss11.service.hw0809;

import com.duong.ss11.dto.hw0809.CategoryUpdateDTO;
import com.duong.ss11.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Optional<Category> findByName(String name);
    boolean addCategoryIfNotExists(String name);
    List<Category> getAll();
    Optional<Category> findById(int id);

    void update(CategoryUpdateDTO dto);

    void delete(int id);

}