package com.duong.ss16.service.hw03.implement;

import com.duong.ss16.dto.hw03.CreateBusDTO;
import com.duong.ss16.dto.hw03.CreateSeatDTO;
import com.duong.ss16.dto.hw03.UpdateBusDTO;
import com.duong.ss16.model.hw03.Bus;
import com.duong.ss16.model.hw03.BusType;
import com.duong.ss16.model.hw03.SeatStatus;
import com.duong.ss16.repository.hw03.BusRepo;
import com.duong.ss16.service.hw03.BusService;
import com.duong.ss16.service.hw03.SeatService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BusServiceImpl implements BusService {
    private final BusRepo busRepo;
    private final SeatService seatService;

    public BusServiceImpl(BusRepo busRepo, SeatService seatService) {
        this.busRepo = busRepo;
        this.seatService = seatService;
    }

    @Override
    public List<Bus> getAll() {
        return busRepo.getAll();
    }

    @Override
    public boolean insertBus(CreateBusDTO createBusDTO) {
        int total  = createBusDTO.getColSeat() * createBusDTO.getRowSeat();
        double seatPrice = createBusDTO.getType() == BusType.NORMAL ? 100
                : createBusDTO.getType() == BusType.VIP ? 150
                : 200;

        if(!busRepo.insertBus(createBusDTO)){
            return false;
        }

        Optional<Bus> busOptional = getLastBus();
        if(busOptional.isEmpty()){
            return false;
        }


        for(int i = 1; i <= total; i++) {
            String seatName = createBusDTO.getLicensePlate()+"-S" + i;

            CreateSeatDTO newSeat = new CreateSeatDTO();
            newSeat.setBusId(busOptional.get().getId());
            newSeat.setName(seatName);
            newSeat.setPrice(seatPrice);
            newSeat.setStatus(SeatStatus.AVAILABLE);

            seatService.insertSeat(newSeat);
        }

        return true;
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
    public Optional<Bus> getLastBus() {
        return busRepo.getLastBus();
    }

    @Override
    public Optional<Bus> findById(int id) {
        return busRepo.findById(id);
    }
}
