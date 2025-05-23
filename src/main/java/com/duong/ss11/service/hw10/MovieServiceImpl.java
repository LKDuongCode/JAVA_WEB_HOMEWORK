package com.duong.ss11.service.hw10;

import com.duong.ss11.model.Movie;
import com.duong.ss11.repository.hw10.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void addMovie(Movie movie) {
        movieRepository.insertMovie(movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        movieRepository.updateMovie(movie);
    }

    @Override
    public void deleteMovie(int id) {
        movieRepository.deleteMovie(id);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAllMovies();
    }

    @Override
    public Movie getMovieById(int id) {
        return movieRepository.findMovieById(id);
    }
}