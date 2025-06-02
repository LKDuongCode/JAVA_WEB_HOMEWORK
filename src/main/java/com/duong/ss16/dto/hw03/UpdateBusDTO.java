package com.duong.ss16.dto.hw03;

import com.duong.ss16.model.hw03.BusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class UpdateBusDTO {
    private int id;
    private String licensePlate;
    private BusType type;
    private int rowSeat;
    private int colSeat;
    private String image;

    private MultipartFile file;

    public UpdateBusDTO(int id, String licensePlate, BusType type, int rowSeat, int colSeat, String image) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.type = type;
        this.rowSeat = rowSeat;
        this.colSeat = colSeat;
        this.image = image;
    }
}
