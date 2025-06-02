package com.duong.ss16.service.hw04;

import com.duong.ss16.dto.hw04.CreateBusTripDTO;
import com.duong.ss16.dto.hw04.UpdateBusTripDTO;
import com.duong.ss16.model.hw04.BusTrip;
import com.duong.ss16.repository.hw04.BusTripRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusTripServiceImpl implements BusTripService {

    private final BusTripRepo busTripRepo;

    public BusTripServiceImpl(BusTripRepo busTripRepo) {
        this.busTripRepo = busTripRepo;
    }
    @Override
    public List<BusTrip> getAll() {
        return busTripRepo.getAll();
    }


    @Override
    public Optional<BusTrip> findById(int id) {
        return busTripRepo.findById(id);
    }

    @Override
    public boolean insertBusTrip(CreateBusTripDTO dto) {
        return busTripRepo.insertBusTrip(dto);
    }

    @Override
    public boolean updateBusTrip(UpdateBusTripDTO dto) {
        return busTripRepo.updateBusTrip(dto);
    }

    @Override
    public boolean deleteBusTrip(int id) {
        return busTripRepo.deleteBusTrip(id);
    }
}