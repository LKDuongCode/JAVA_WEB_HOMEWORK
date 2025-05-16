package com.duong.ss09.service.hw02;

import com.duong.ss09.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies();
    Optional<Movie> findById(Long id);
}