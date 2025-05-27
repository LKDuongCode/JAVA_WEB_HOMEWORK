package com.duong.ss12.dto.hw03;

import com.duong.ss12.model.SeatStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSeatDTO {
    private int id;
    private int busId;

    @NotBlank
    private String nameSeat;

    @Min(10000)
    private int price;

    @NotNull
    private SeatStatus status;
}
