package com.duong.ss12.model;

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
    private String nameSeat;
    private int price;
    private int busId;
    private SeatStatus status;
}
