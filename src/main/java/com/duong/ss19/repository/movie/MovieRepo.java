package com.duong.ss19.repository.movie;

import com.duong.ss19.entity.movie.Movie;

import java.util.List;

public interface MovieRepo {
    List<Movie> findAll();

    Movie findById(Long id);

    void save(Movie movie);

    void update(Movie movie);

    void delete(Long id);

    boolean hasSchedule(Long movieId);
}
