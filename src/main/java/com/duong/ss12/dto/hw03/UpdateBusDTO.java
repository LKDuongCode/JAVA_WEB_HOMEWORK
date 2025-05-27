package com.duong.ss12.dto.hw03;

import com.duong.ss12.model.BusType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBusDTO {

    private int id;

    @NotBlank(message = "License plate cannot be blank!")
    @Size(max = 20, message = "License plate must not exceed 20 characters!")
    private String licensePlate;

    @NotNull(message = "Bus type cannot be null!")
    private BusType busType;

    @Min(value = 1, message = "Row seat must be greater than 0!")
    private int rowSeat;

    @Min(value = 1, message = "Column seat must be greater than 0!")
    private int colSeat;

    private String image;

    private MultipartFile imageFile;

    public UpdateBusDTO(int id, String licensePlate, BusType busType, int rowSeat, int colSeat, String image) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.busType = busType;
        this.rowSeat = rowSeat;
        this.colSeat = colSeat;
        this.image = image;
    }
}
