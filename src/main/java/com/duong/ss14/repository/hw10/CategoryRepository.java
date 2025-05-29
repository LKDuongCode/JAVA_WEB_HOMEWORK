package com.duong.ss14.repository.hw10;

import com.duong.ss14.dto.hw10.CreateLangDTO;
import com.duong.ss14.model.Category;

import java.util.List;

public interface CategoryRepository {
    boolean insertCategoryVi(CreateLangDTO dto);
    boolean insertCategoryEn(CreateLangDTO dto);
    List<Category> getAllCategoriesVi();
    List<Category> getAllCategoriesEn();
}
