package com.duong.ss19.service.room;

import com.duong.ss19.dto.room.ScreenRoomDTO;

import java.util.List;

public interface ScreenRoomService {
    List<ScreenRoomDTO> getAllActive();
    ScreenRoomDTO getById(Long id);
    void create(ScreenRoomDTO dto);
    void update(ScreenRoomDTO dto);
    void delete(Long id);
}
