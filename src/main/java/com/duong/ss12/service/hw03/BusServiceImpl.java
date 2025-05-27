package com.duong.ss12.service.hw03;

import com.duong.ss12.dto.hw03.CreateBusDTO;
import com.duong.ss12.dto.hw03.UpdateBusDTO;
import com.duong.ss12.model.Bus;
import com.duong.ss12.repository.hw03.BusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {
    private final BusRepo busRepo;

    public BusServiceImpl(BusRepo busRepo) {
        this.busRepo = busRepo;
    }

    @Override
    public List<Bus> getAllBus() {
        return busRepo.getAllBus();
    }

    @Override
    public boolean insertBus(CreateBusDTO createBusDTO) {
        return busRepo.insertBus(createBusDTO);
    }

    @Override
    public boolean updateBus(UpdateBusDTO updateBusDTO) {
        return busRepo.updateBus(updateBusDTO);
    }

    @Override
    public boolean deleteBus(int id) {
        return busRepo.deleteBus(id);
    }

    @Override
    public Optional<Bus> findById(int id) {
        return busRepo.findById(id);
    }

    @Override
    public Optional<Bus> findByLicensePlate(String licensePlate) {
        return busRepo.findByLicensePlate(licensePlate);
    }
}
