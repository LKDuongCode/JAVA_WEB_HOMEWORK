package com.duong.ss09.service.hw03.impl;

import com.duong.ss09.model.ScreenRoom;
import com.duong.ss09.repository.hw03.ScreenRoomRepo;
import com.duong.ss09.service.hw03.ScreenRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreenRoomServiceImpl implements ScreenRoomService {

    @Autowired
    private ScreenRoomRepo screenRoomRepo;

    @Override
    public List<ScreenRoom> findAll() {
        return screenRoomRepo.findAll();
    }

    @Override
    public Optional<ScreenRoom> findById(Long id) {
        return screenRoomRepo.findById(id);
    }
}