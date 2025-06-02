package com.duong.ss16.dto.hw05;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreateTicketDTO {
    private int userId;
    private int tripBusId;
    private List<String> selectedSeats; // từ form
    private double totalMoney;
    private LocalDate departureDate;

    public String getListSeat() {
        return String.join(",", selectedSeats);
    }
}
