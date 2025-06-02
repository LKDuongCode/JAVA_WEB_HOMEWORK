package com.duong.ss16.model.hw05;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private int id;
    private int userId;
    private int tripBusId;
    private String listSeat;
    private double totalMoney;
    private LocalDate departureDate;
}
