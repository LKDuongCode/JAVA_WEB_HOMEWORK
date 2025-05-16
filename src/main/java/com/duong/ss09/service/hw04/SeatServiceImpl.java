package com.duong.ss09.service.hw04;

import com.duong.ss09.model.Seat;
import com.duong.ss09.repository.hw04.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatRepo seatRepo;

    @Override
    public List<Seat> findByScreenRoomId(Long roomId) {
        return seatRepo.findByScreenRoomId(roomId);
    }
}
