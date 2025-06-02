package com.duong.ss16.repository.hw05;

import com.duong.ss16.dto.hw05.CreateTicketDTO;

public interface TicketRepo {
    boolean insertTicket(CreateTicketDTO dto);
}
