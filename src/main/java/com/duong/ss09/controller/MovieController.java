package com.duong.ss09.controller;

import com.duong.ss09.service.hw02.MovieService;
import com.duong.ss09.service.hw03.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/home")
    public String showAllMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "home";
    }


    @GetMapping("/movie/{id}")
    public String showMovieDetail(@PathVariable("id") Long id, Model model) {
        movieService.findById(id).ifPresentOrElse(
                movie -> {
                    model.addAttribute("movie", movie);
                    model.addAttribute("schedules", scheduleService.findAllScheduleByMovie(id));
                },
                () -> model.addAttribute("error", "Không tìm thấy phim.")
        );
        return "detailMovie";
    }

}