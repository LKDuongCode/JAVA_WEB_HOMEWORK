package com.duong.ss09.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Ticket {
    private Long id;
    private Long customerId;
    private Long scheduleId;
    private List<Seat> listSeat;
    private Double totalMoney;
    private LocalDateTime createdAt;

    public Ticket(Long id, Long customerId, Long scheduleId, Double totalMoney, LocalDateTime createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.scheduleId = scheduleId;
        this.totalMoney = totalMoney;
        this.createdAt = createdAt;
    }

}