package com.duong.ss11.repository.hw0809;

import com.duong.ss11.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepo {
    Optional<Category> findCategoryByName(String name);
    void insertCategory(String name);
    List<Category> findAllCategories();
    Optional<Category> findById(int id);
    void update(Category category);
    void delete(int id);
}
