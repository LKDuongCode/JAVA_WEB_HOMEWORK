package com.duong.ss12.repository.hw03;

import com.duong.ss12.dto.hw03.CreateSeatDTO;
import com.duong.ss12.dto.hw03.UpdateSeatDTO;
import com.duong.ss12.model.Seat;

import java.util.List;
import java.util.Optional;

public interface SeatRepo {
    List<Seat> getSeatsByBusId(int busId);
    boolean insertSeat(CreateSeatDTO dto);
    boolean updateSeat(UpdateSeatDTO dto);
    boolean deleteSeatById(int id);
    boolean deleteSeatsByBusId(int busId);
    Optional<Seat> findById(int id);
}
