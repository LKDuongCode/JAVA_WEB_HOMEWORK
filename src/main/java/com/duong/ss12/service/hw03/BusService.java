package com.duong.ss12.service.hw03;

import com.duong.ss12.dto.hw03.CreateBusDTO;
import com.duong.ss12.dto.hw03.UpdateBusDTO;
import com.duong.ss12.model.Bus;

import java.util.List;
import java.util.Optional;

public interface BusService {
    List<Bus> getAllBus();
    boolean insertBus(CreateBusDTO createBusDTO);
    boolean updateBus(UpdateBusDTO updateBusDTO);
    boolean deleteBus(int id);
    Optional<Bus> findById(int id);
    Optional<Bus> findByLicensePlate(String licensePlate);
}
