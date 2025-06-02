package com.duong.ss16.service.hw05;

import com.duong.ss16.dto.hw05.CreateTicketDTO;
import com.duong.ss16.repository.hw05.TicketRepo;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepo ticketRepo;

    public TicketServiceImpl(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    @Override
    public boolean insertTicket(CreateTicketDTO dto) {
        return ticketRepo.insertTicket(dto);
    }
}
