package com.duong.ss09.service.hw02;

import com.duong.ss09.model.Movie;
import com.duong.ss09.repository.hw02.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepo movieRepo;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.getAllMovies();
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieRepo.findById(id);
    }
}