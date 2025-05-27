package com.duong.ss12.dto.hw03;

import com.duong.ss12.model.BusType;
import com.duong.ss12.validate.hw02.ValidImage;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class CreateBusDTO {

    @NotBlank(message = "License plate cannot be blank!")
    @Size(max = 20, message = "License plate must not exceed 20 characters!")
    private String licensePlate;

    @NotNull(message = "Bus type cannot be null!")
    private BusType busType;

    @Min(value = 1, message = "Row seat must be greater than 0!")
    private int rowSeat;

    @Min(value = 1, message = "Column seat must be greater than 0!")
    private int colSeat;

    private MultipartFile imageFile;

    private String image;

    public CreateBusDTO(String licensePlate, BusType busType, int rowSeat, int colSeat, String image) {
        this.licensePlate = licensePlate;
        this.busType = busType;
        this.rowSeat = rowSeat;
        this.colSeat = colSeat;
        this.image = image;
    }
}

