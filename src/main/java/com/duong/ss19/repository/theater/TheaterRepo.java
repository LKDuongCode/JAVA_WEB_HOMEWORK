package com.duong.ss19.repository.theater;

import com.duong.ss19.entity.theater.Theater;

import java.util.List;

public interface TheaterRepo {
    List<Theater> findAll();
    Theater findById(Long id);
    void save(Theater theater);
    void update(Theater theater);
    void delete(Long id);
    boolean hasSchedule(Long theaterId);
}
