package com.duong.ss11.controller.hw10;

import com.duong.ss11.dto.hw10.MovieCreateDTO;
import com.duong.ss11.dto.hw10.MovieUpdateDTO;
import com.duong.ss11.model.Movie;
import com.duong.ss11.service.hw10.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hw10")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "hw10_list";
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("movieCreateDTO", new MovieCreateDTO());
        return "hw10_form";
    }


    public String addMovie(@Valid @ModelAttribute("movieCreateDTO") MovieCreateDTO dto, BindingResult result) {
        if (result.hasErrors()) return "hw10_form";

        Movie movie = new Movie(0, dto.getTitle(), dto.getDirector(), dto.getReleaseDate(), dto.getGenre(), dto.getPoster());
        movieService.addMovie(movie);
        return "redirect:/hw10";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Movie movie = movieService.getMovieById(id);
        if (movie == null) return "redirect:/hw10";

        MovieUpdateDTO dto = new MovieUpdateDTO(movie.getId(), movie.getTitle(), movie.getDirector(), movie.getReleaseDate(), movie.getGenre(), movie.getPoster());
        model.addAttribute("movieUpdateDTO", dto);
        return "hw10_edit";

    }

    public String editMovie(@Valid @ModelAttribute("movieUpdateDTO") MovieUpdateDTO dto, BindingResult result) {
        if (result.hasErrors()) return "hw10_edit";

        Movie movie = new Movie(dto.getId(), dto.getTitle(), dto.getDirector(), dto.getReleaseDate(), dto.getGenre(), dto.getPoster());
        movieService.updateMovie(movie);
        return "redirect:/hw10";
    }


    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return "redirect:/hw10";
    }
}