package com.duong.ss16.model.hw04;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BusTrip {
    private int id;
    private String departurePoint;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int busId;
    private int seatsAvailable;
    private String image;
}
