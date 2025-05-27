package com.duong.ss12.service.hw03;

import com.duong.ss12.dto.hw03.CreateSeatDTO;
import com.duong.ss12.dto.hw03.UpdateSeatDTO;
import com.duong.ss12.model.Seat;
import com.duong.ss12.repository.hw03.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepo seatRepo;

    public SeatServiceImpl(SeatRepo seatRepo) {
        this.seatRepo = seatRepo;
    }

    @Override
    public List<Seat> getSeatsByBusId(int busId) {
        return seatRepo.getSeatsByBusId(busId);
    }

    @Override
    public boolean insertSeat(CreateSeatDTO createSeatDTO) {
        return seatRepo.insertSeat(createSeatDTO);
    }

    @Override
    public boolean updateSeat(UpdateSeatDTO updateSeatDTO) {
        return seatRepo.updateSeat(updateSeatDTO);
    }

    @Override
    public boolean deleteSeatById(int id) {
        return seatRepo.deleteSeatById(id);
    }

    @Override
    public boolean deleteSeatsByBusId(int busId) {
        return seatRepo.deleteSeatsByBusId(busId);
    }

    @Override
    public Optional<Seat> findById(int id) {
        return seatRepo.findById(id);
    }
}
