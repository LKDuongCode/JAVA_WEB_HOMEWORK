package com.duong.ss19.service.movie;

import com.duong.ss19.dto.movie.MovieDTO;

import java.util.List;

public interface MovieService {
    List<MovieDTO> getAll();

    MovieDTO getById(Long id);

    void create(MovieDTO dto);

    void update(MovieDTO dto);

    void delete(Long id);
}
