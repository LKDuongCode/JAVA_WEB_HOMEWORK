package com.duong.ss14.controller.hw10;

import com.duong.ss14.dto.hw10.CreateLangDTO;
import com.duong.ss14.model.Category;
import com.duong.ss14.service.hw10.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String showCategoryList(Locale locale, Model model) {
        List<Category> list = categoryService.getAllCategoriesByLocale(locale);
        model.addAttribute("categories", list);
        return "hw10_list";
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        CreateLangDTO vnDTO = new CreateLangDTO();

        CreateLangDTO engDTO = new CreateLangDTO();

        model.addAttribute("vi", vnDTO);
        model.addAttribute("en", engDTO);

        return "hw10_add";
    }

    @PostMapping("/add")
    public String handleAddCategory(
            @RequestParam("vi.categoryName") String viName,
            @RequestParam("vi.description") String viDesc,
            @RequestParam("en.categoryName") String enName,
            @RequestParam("en.description") String enDesc,
            Model model
    ) {
        CreateLangDTO viDTO = new CreateLangDTO(viName, viDesc);
        CreateLangDTO enDTO = new CreateLangDTO(enName, enDesc);


        model.addAttribute("vi", viDTO);
        model.addAttribute("en", enDTO);


        boolean viSaved = categoryService.saveCategoryVi(viDTO);
        boolean enSaved = categoryService.saveCategoryEn(enDTO);

        if (viSaved && enSaved) {
            return "redirect:/categories/list";
        }
        return "error";
    }



}
