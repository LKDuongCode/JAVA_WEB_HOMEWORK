package com.duong.ss16.model.hw03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    private int id;
    private String name;
    private double price;
    private SeatStatus status;
    private int busId;
}
