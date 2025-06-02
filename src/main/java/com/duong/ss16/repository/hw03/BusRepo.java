package com.duong.ss16.repository.hw03;

import com.duong.ss16.dto.hw03.CreateBusDTO;
import com.duong.ss16.dto.hw03.UpdateBusDTO;
import com.duong.ss16.model.hw03.Bus;

import java.util.List;
import java.util.Optional;

public interface BusRepo {
    List<Bus> getAll ();
    boolean insertBus (CreateBusDTO createBusDTO);
    boolean updateBus (UpdateBusDTO updateBusDTO);
    boolean deleteBus (int id);
    Optional<Bus> getLastBus ();
    Optional<Bus> findById(int id);
}
