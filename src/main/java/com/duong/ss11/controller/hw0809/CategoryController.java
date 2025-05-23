package com.duong.ss11.controller.hw0809;

import com.duong.ss11.dto.hw0809.CategoryDTO;
import com.duong.ss11.dto.hw0809.CategoryUpdateDTO;
import com.duong.ss11.model.Category;
import com.duong.ss11.service.hw0809.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/hw0809")
    public String list(Model model) {
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "hw0809_list";
    }

    @GetMapping("/hw0809-add-form")
    public String showAddForm(Model model) {
        model.addAttribute("categoryDTO", new CategoryDTO());
        return "hw0809_add";
    }

    @PostMapping("/hw0809-add-save")
    public String handleAdd(
            @Valid @ModelAttribute("categoryDTO") CategoryDTO dto,
            BindingResult result,
            RedirectAttributes redirect) {

        if (result.hasErrors()) {
            return "hw0809_add";
        }

        categoryService.addCategoryIfNotExists(dto.getName());
        redirect.addFlashAttribute("message", "Category added successfully!");
        return "redirect:/hw0809";
    }


    @GetMapping("/hw0809-edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model, RedirectAttributes redirect) {

        return categoryService.findById(id).map(category -> {
            CategoryUpdateDTO dto = new CategoryUpdateDTO();
            dto.setId(category.getId());
            dto.setName(category.getName());
            model.addAttribute("categoryUpdateDTO", dto);
            return "hw0809_edit";
        }).orElseGet(() -> {
            redirect.addFlashAttribute("error", "Category not found");
            return "redirect:/hw0809";
        });
    }

    @PostMapping("/hw0809-update")
    public String handleUpdate(
            @Valid @ModelAttribute("categoryUpdateDTO") CategoryUpdateDTO dto,
            BindingResult result,
            RedirectAttributes redirect) {

        if (result.hasErrors()) {
            return "hw0809_edit";
        }

        categoryService.update(dto);
        redirect.addFlashAttribute("message", "Category updated successfully!");
        return "redirect:/hw0809";
    }

    @PostMapping("/hw0809-delete/{id}")
    public String handleDelete(@PathVariable("id") int id, RedirectAttributes redirect) {
        categoryService.delete(id);
        redirect.addFlashAttribute("message", "Category deleted successfully!");
        return "redirect:/hw0809";
    }
}
