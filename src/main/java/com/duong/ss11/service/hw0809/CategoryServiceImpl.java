package com.duong.ss11.service.hw0809;

import com.duong.ss11.dto.hw0809.CategoryUpdateDTO;
import com.duong.ss11.model.Category;
import com.duong.ss11.repository.hw0809.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Optional<Category> findByName(String name) {
        return categoryRepo.findCategoryByName(name);
    }

    @Override
    public boolean addCategoryIfNotExists(String name) {
        Optional<Category> existing = categoryRepo.findCategoryByName(name);
        if (existing.isPresent()) {
            return false;
        }
        categoryRepo.insertCategory(name);
        return true;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepo.findAllCategories();
    }

    @Override
    public Optional<Category> findById(int id) {
        return categoryRepo.findById(id);
    }

    @Override
    public void update(CategoryUpdateDTO dto) {
        categoryRepo.findById(dto.getId()).ifPresent(category -> {
            category.setName(dto.getName());
            categoryRepo.update(category);
        });
    }

    @Override
    public void delete(int id) {
        categoryRepo.delete(id);
    }

}