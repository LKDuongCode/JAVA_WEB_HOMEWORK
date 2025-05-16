package com.duong.ss09.repository.hw03;


import com.duong.ss09.model.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepo {
    List<Schedule> findAllScheduleByMovie(Long movieId);
    Optional<Schedule> findById(Long id);
}