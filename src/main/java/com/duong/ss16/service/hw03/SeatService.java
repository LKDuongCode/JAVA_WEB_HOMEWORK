package com.duong.ss16.service.hw03;

import com.duong.ss16.dto.hw03.CreateSeatDTO;

public interface SeatService {
    boolean insertSeat (CreateSeatDTO createSeatDTO);
    boolean deleteSeatByBusId (int busId);
}
