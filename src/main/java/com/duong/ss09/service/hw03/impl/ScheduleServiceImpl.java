package com.duong.ss09.service.hw03.impl;

import com.duong.ss09.model.Schedule;
import com.duong.ss09.repository.hw03.ScheduleRepo;
import com.duong.ss09.service.hw03.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepo scheduleRepo;

    @Override
    public List<Schedule> findAllScheduleByMovie(Long movieId) {
        return scheduleRepo.findAllScheduleByMovie(movieId);
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        return scheduleRepo.findById(id);
    }
}