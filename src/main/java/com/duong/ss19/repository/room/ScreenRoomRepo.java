package com.duong.ss19.repository.room;

import com.duong.ss19.entity.screenroom.ScreenRoom;

import java.util.List;

public interface ScreenRoomRepo {
    List<ScreenRoom> findAllActive();
    ScreenRoom findById(Long id);
    void save(ScreenRoom room);
    void update(ScreenRoom room);
    void deleteLogic(Long id);
}
