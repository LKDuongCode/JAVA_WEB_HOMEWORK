package com.duong.ss14.service.hw10;

import com.duong.ss14.dto.hw10.CreateLangDTO;
import com.duong.ss14.model.Category;

import java.util.List;
import java.util.Locale;

public interface CategoryService {
    boolean saveCategoryVi(CreateLangDTO dto);
    boolean saveCategoryEn(CreateLangDTO dto);
    List<Category> getAllCategoriesByLocale(Locale locale);
}
