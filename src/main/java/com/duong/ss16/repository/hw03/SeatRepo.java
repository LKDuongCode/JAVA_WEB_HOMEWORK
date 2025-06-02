package com.duong.ss16.repository.hw03;

import com.duong.ss16.dto.hw03.CreateSeatDTO;

public interface SeatRepo {
    boolean insertSeat (CreateSeatDTO createSeatDTO);
    boolean deleteSeatByBusId (int busId);
}
