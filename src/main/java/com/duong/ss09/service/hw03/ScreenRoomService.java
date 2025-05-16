package com.duong.ss09.service.hw03;

import com.duong.ss09.model.ScreenRoom;

import java.util.List;
import java.util.Optional;

public interface ScreenRoomService {
    List<ScreenRoom> findAll();
    Optional<ScreenRoom> findById(Long id);
}
