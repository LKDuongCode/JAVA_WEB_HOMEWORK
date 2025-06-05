package com.duong.ss19.controller.theater;

import com.duong.ss19.dto.theater.TheaterDTO;
import com.duong.ss19.service.theater.TheaterService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/theaters")
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("theaters", theaterService.getAll());
        return "theater_list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("theaterDTO", new TheaterDTO());
        return "theater_create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("theaterDTO") TheaterDTO dto,
                         BindingResult result) {
        if (result.hasErrors()) return "theater_create";
        theaterService.create(dto);
        return "redirect:/theaters";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        TheaterDTO dto = theaterService.getById(id);
        if (dto == null) return "redirect:/theaters";
        model.addAttribute("theaterDTO", dto);
        return "theater_edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("theaterDTO") TheaterDTO dto,
                         BindingResult result) {
        if (result.hasErrors()) return "theater_edit";
        theaterService.update(dto);
        return "redirect:/theaters";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        theaterService.delete(id);
        return "redirect:/theaters";
    }
}
