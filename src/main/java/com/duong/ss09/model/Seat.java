package com.duong.ss09.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    private Long id;
    private Long screenRoomId;
    private Double price = 50000.0;
    private SeatStatus status;
}