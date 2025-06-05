package com.duong.ss19.service.movie;

import com.duong.ss19.dto.movie.MovieDTO;
import com.duong.ss19.entity.movie.Movie;
import com.duong.ss19.repository.movie.MovieRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepo movieRepo;

    public MovieServiceImpl(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public List<MovieDTO> getAll() {
        List<Movie> movies = movieRepo.findAll();
        List<MovieDTO> result = new ArrayList<>();
        for (Movie movie : movies) {
            MovieDTO dto = new MovieDTO();
            dto.setId(movie.getId());
            dto.setTitle(movie.getTitle());
            dto.setDirector(movie.getDirector());
            dto.setReleaseYear(movie.getReleaseYear());
            dto.setGenre(movie.getGenre());
            dto.setDuration(movie.getDuration());
            dto.setLanguage(movie.getLanguage());
            dto.setPoster(movie.getPoster());
            dto.setStatus(movie.isStatus());
            result.add(dto);
        }
        return result;
    }

    @Override
    public MovieDTO getById(Long id) {
        Movie movie = movieRepo.findById(id);
        if (movie == null) return null;

        MovieDTO dto = new MovieDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setDirector(movie.getDirector());
        dto.setReleaseYear(movie.getReleaseYear());
        dto.setGenre(movie.getGenre());
        dto.setDuration(movie.getDuration());
        dto.setLanguage(movie.getLanguage());
        dto.setPoster(movie.getPoster());
        dto.setStatus(movie.isStatus());
        return dto;
    }

    @Override
    public void create(MovieDTO dto) {
        Movie movie = new Movie();
        movie.setTitle(dto.getTitle());
        movie.setDirector(dto.getDirector());
        movie.setReleaseYear(dto.getReleaseYear());
        movie.setGenre(dto.getGenre());
        movie.setDuration(dto.getDuration());
        movie.setLanguage(dto.getLanguage());
        movie.setPoster(dto.getPoster());
        movie.setStatus(dto.isStatus());
        movieRepo.save(movie);
    }

    @Override
    public void update(MovieDTO dto) {
        Movie movie = movieRepo.findById(dto.getId());
        if (movie != null) {
            movie.setTitle(dto.getTitle());
            movie.setDirector(dto.getDirector());
            movie.setReleaseYear(dto.getReleaseYear());
            movie.setGenre(dto.getGenre());
            movie.setDuration(dto.getDuration());
            movie.setLanguage(dto.getLanguage());
            movie.setPoster(dto.getPoster());
            movie.setStatus(dto.isStatus());
            movieRepo.update(movie);
        }
    }

    @Override
    public void delete(Long id) {
        if (movieRepo.hasSchedule(id)) {
            Movie movie = movieRepo.findById(id);
            if (movie != null) {
                movie.setStatus(false);
                movieRepo.update(movie);
            }
        } else {
            movieRepo.delete(id);
        }
    }
}
