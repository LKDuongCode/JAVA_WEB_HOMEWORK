package com.duong.ss14.service.hw10;

import com.duong.ss14.dto.hw10.CreateLangDTO;
import com.duong.ss14.model.Category;
import com.duong.ss14.repository.hw10.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean saveCategoryVi(CreateLangDTO dto) {
        return categoryRepository.insertCategoryVi(dto);
    }

    @Override
    public boolean saveCategoryEn(CreateLangDTO dto) {
        return categoryRepository.insertCategoryEn(dto);
    }

    @Override
    public List<Category> getAllCategoriesByLocale(Locale locale) {
        if ("en".equals(locale.getLanguage())) {
            return categoryRepository.getAllCategoriesEn();
        }
        return categoryRepository.getAllCategoriesVi();
    }
}
