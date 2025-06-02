package com.duong.ss16.dto.hw03;

import com.duong.ss16.model.hw03.SeatStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateSeatDTO {
    private String name;
    private double price;
    private SeatStatus status;
    private int busId;
}
