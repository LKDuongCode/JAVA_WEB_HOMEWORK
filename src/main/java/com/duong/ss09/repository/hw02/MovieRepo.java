package com.duong.ss09.repository.hw02;

import com.duong.ss09.model.Movie;
import java.util.List;
import java.util.Optional;

public interface MovieRepo {
    List<Movie> getAllMovies();
    Optional<Movie> findById(Long id);
}
