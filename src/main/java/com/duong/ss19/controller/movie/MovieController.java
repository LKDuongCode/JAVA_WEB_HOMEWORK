package com.duong.ss19.controller.movie;

import com.duong.ss19.dto.movie.MovieDTO;
import com.duong.ss19.service.movie.MovieService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("movies", movieService.getAll());
        return "movie_list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("movieDTO", new MovieDTO());
        return "movie_create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("movieDTO") MovieDTO dto,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "movie_create";
        }
        movieService.create(dto);
        return "redirect:/movies";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        MovieDTO dto = movieService.getById(id);
        if (dto == null) {
            return "redirect:/movies";
        }
        model.addAttribute("movieDTO", dto);
        return "movie_edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("movieDTO") MovieDTO dto,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "movie_edit";
        }
        movieService.update(dto);
        return "redirect:/movies";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        movieService.delete(id);
        return "redirect:/movies";
    }
}
