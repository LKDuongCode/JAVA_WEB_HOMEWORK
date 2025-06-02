package com.duong.ss16.dto.hw04;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UpdateBusTripDTO {
    private int id;
    private String departurePoint;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int busId;
    private int seatsAvailable;
    private String image;

    private MultipartFile file;

    public UpdateBusTripDTO(int id, String departurePoint, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, int busId, int seatsAvailable, String image) {
        this.id = id;
        this.departurePoint = departurePoint;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.busId = busId;
        this.seatsAvailable = seatsAvailable;
        this.image = image;
    }
}