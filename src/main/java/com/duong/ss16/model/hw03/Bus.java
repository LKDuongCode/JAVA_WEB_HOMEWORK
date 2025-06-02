package com.duong.ss16.model.hw03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
    private int id;
    private String licensePlate;
    private BusType type;
    private int rowSeat;
    private int colSeat;
    private String image;
}
