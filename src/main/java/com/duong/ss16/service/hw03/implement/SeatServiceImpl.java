package com.duong.ss16.service.hw03.implement;

import com.duong.ss16.dto.hw03.CreateSeatDTO;
import com.duong.ss16.repository.hw03.SeatRepo;
import com.duong.ss16.service.hw03.SeatService;
import org.springframework.stereotype.Service;


@Service
public class SeatServiceImpl implements SeatService {
    private final SeatRepo seatRepo;

    public SeatServiceImpl(SeatRepo seatRepo) {
        this.seatRepo = seatRepo;
    }

    @Override
    public boolean insertSeat(CreateSeatDTO createSeatDTO) {
        return seatRepo.insertSeat(createSeatDTO);
    }

    @Override
    public boolean deleteSeatByBusId(int busId) {

        return seatRepo.deleteSeatByBusId(busId);
    }
}
