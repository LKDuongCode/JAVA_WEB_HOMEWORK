package com.duong.ss19.service.room;

import com.duong.ss19.dto.room.ScreenRoomDTO;
import com.duong.ss19.entity.screenroom.ScreenRoom;
import com.duong.ss19.entity.seat.Seat;
import com.duong.ss19.entity.theater.Theater;
import com.duong.ss19.repository.room.ScreenRoomRepo;
import com.duong.ss19.repository.theater.TheaterRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScreenRoomServiceImpl implements ScreenRoomService {

    private final ScreenRoomRepo screenRoomDAO;
    private final TheaterRepo theaterDAO;

    public ScreenRoomServiceImpl(ScreenRoomRepo screenRoomDAO, TheaterRepo theaterDAO) {
        this.screenRoomDAO = screenRoomDAO;
        this.theaterDAO = theaterDAO;
    }

    @Override
    public List<ScreenRoomDTO> getAllActive() {
        List<ScreenRoomDTO> result = new ArrayList<>();
        for (ScreenRoom r : screenRoomDAO.findAllActive()) {
            ScreenRoomDTO dto = new ScreenRoomDTO(
                    r.getId(), r.getRoomName(), r.getCapacity(),
                    r.getScreenType(), r.isStatus(),
                    r.getTheater().getId(), r.getTheater().getTheaterName()
            );
            result.add(dto);
        }
        return result;
    }

    @Override
    public ScreenRoomDTO getById(Long id) {
        ScreenRoom r = screenRoomDAO.findById(id);
        if (r == null) return null;
        return new ScreenRoomDTO(r.getId(), r.getRoomName(), r.getCapacity(),
                r.getScreenType(), r.isStatus(), r.getTheater().getId(), r.getTheater().getTheaterName());
    }

    @Override
    public void create(ScreenRoomDTO dto) {
        Theater theater = theaterDAO.findById(dto.getTheaterId());
        if (theater == null) return;

        ScreenRoom room = new ScreenRoom();
        room.setRoomName(dto.getRoomName());
        room.setCapacity(dto.getCapacity());
        room.setScreenType(dto.getScreenType());
        room.setStatus(dto.isStatus());
        room.setTheater(theater);

        // tạo ghế
        List<Seat> seats = new ArrayList<>();
        int rows = (int) Math.ceil(dto.getCapacity() / 10.0);
        int index = 0;
        for (char row = 'A'; row < 'A' + rows; row++) {
            for (int num = 1; num <= 10 && index < dto.getCapacity(); num++) {
                Seat seat = new Seat();
                seat.setSeatName(row + String.valueOf(num));
                seat.setStatus(true);
                seat.setScreenRoom(room);
                seats.add(seat);
                index++;
            }
        }

        room.setSeats(seats);
        screenRoomDAO.save(room);
    }

    @Override
    public void update(ScreenRoomDTO dto) {
        ScreenRoom room = screenRoomDAO.findById(dto.getId());
        if (room != null) {
            room.setRoomName(dto.getRoomName());
            room.setScreenType(dto.getScreenType());
            room.setStatus(dto.isStatus());
            // capacity và ghế giữ nguyên để tránh rối
            screenRoomDAO.update(room);
        }
    }

    @Override
    public void delete(Long id) {
        screenRoomDAO.deleteLogic(id);
    }
}
