package com.duong.ss11.service.hw10;

import com.duong.ss11.model.Movie;

import java.util.List;

public interface MovieService {
    void addMovie(Movie movie);

    void updateMovie(Movie movie);

    void deleteMovie(int id);

    List<Movie> getAllMovies();

    Movie getMovieById(int id);
}