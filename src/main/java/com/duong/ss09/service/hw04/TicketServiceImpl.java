package com.duong.ss09.service.hw04;

import com.duong.ss09.model.Ticket;
import com.duong.ss09.repository.hw04.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepo ticketRepo;

    @Override
    public void addTicket(Ticket ticket) {
        ticketRepo.addTicket(ticket);
    }
}