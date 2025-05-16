package com.duong.ss09.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private Long id;
    private Long movieId;
    private LocalDateTime showTime;
    private Long screenRoomId;
    private Integer availableSeats;
    private MovieFormat format;
}