package com.duong.ss19.service.theater;

import com.duong.ss19.dto.theater.TheaterDTO;

import java.util.List;

public interface TheaterService {
    List<TheaterDTO> getAll();
    TheaterDTO getById(Long id);
    void create(TheaterDTO dto);
    void update(TheaterDTO dto);
    void delete(Long id);
}
