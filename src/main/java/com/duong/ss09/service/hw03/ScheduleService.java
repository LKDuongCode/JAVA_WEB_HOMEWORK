package com.duong.ss09.service.hw03;

import com.duong.ss09.model.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {
    List<Schedule> findAllScheduleByMovie(Long movieId);
    Optional<Schedule> findById(Long id);
}
