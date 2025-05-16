package com.duong.ss09.service.hw04;

import com.duong.ss09.model.Seat;

import java.util.List;

public interface SeatService {
    List<Seat> findByScreenRoomId(Long roomId);
}