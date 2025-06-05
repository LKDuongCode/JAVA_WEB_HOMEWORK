package com.duong.ss19.service.theater;

import com.duong.ss19.dto.theater.TheaterDTO;
import com.duong.ss19.entity.theater.Theater;
import com.duong.ss19.repository.theater.TheaterRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepo theaterRepo;

    public TheaterServiceImpl(TheaterRepo theaterRepo) {
        this.theaterRepo = theaterRepo;
    }

    @Override
    public List<TheaterDTO> getAll() {
        List<TheaterDTO> result = new ArrayList<>();
        for (Theater t : theaterRepo.findAll()) {
            TheaterDTO dto = new TheaterDTO(t.getId(), t.getTheaterName(), t.getAddress(), t.getNumberScreenRoom(), t.isStatus());
            result.add(dto);
        }
        return result;
    }

    @Override
    public TheaterDTO getById(Long id) {
        Theater t = theaterRepo.findById(id);
        return t == null ? null : new TheaterDTO(t.getId(), t.getTheaterName(), t.getAddress(), t.getNumberScreenRoom(), t.isStatus());
    }

    @Override
    public void create(TheaterDTO dto) {
        Theater t = new Theater(null, dto.getTheaterName(), dto.getAddress(), dto.getNumberScreenRoom(), dto.isStatus());
        theaterRepo.save(t);
    }

    @Override
    public void update(TheaterDTO dto) {
        Theater t = theaterRepo.findById(dto.getId());
        if (t != null) {
            t.setTheaterName(dto.getTheaterName());
            t.setAddress(dto.getAddress());
            t.setNumberScreenRoom(dto.getNumberScreenRoom());
            t.setStatus(dto.isStatus());
            theaterRepo.update(t);
        }
    }

    @Override
    public void delete(Long id) {
        if (theaterRepo.hasSchedule(id)) {
            Theater t = theaterRepo.findById(id);
            if (t != null) {
                t.setStatus(false);
                theaterRepo.update(t);
            }
        } else {
            theaterRepo.delete(id);
        }
    }
}
