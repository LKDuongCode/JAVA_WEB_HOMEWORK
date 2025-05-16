package com.duong.ss09.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScreenRoom {
    private Long id;
    private String screenRoomName;
    private Integer totalSeat;
}