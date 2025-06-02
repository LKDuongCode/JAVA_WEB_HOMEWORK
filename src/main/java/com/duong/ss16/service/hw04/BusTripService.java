package com.duong.ss16.service.hw04;

import com.duong.ss16.dto.hw04.CreateBusTripDTO;
import com.duong.ss16.dto.hw04.UpdateBusTripDTO;
import com.duong.ss16.model.hw04.BusTrip;

import java.util.List;
import java.util.Optional;

public interface BusTripService {
    List<BusTrip> getAll();
    Optional<BusTrip> findById(int id);
    boolean insertBusTrip(CreateBusTripDTO dto);
    boolean updateBusTrip(UpdateBusTripDTO dto);
    boolean deleteBusTrip(int id);
}
