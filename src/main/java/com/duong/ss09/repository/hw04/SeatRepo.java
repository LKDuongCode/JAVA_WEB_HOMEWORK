package com.duong.ss09.repository.hw04;


import com.duong.ss09.model.Seat;

import java.util.List;

public interface SeatRepo {
    List<Seat> findByScreenRoomId(Long roomId);
}