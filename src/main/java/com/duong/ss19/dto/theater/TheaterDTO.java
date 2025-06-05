package com.duong.ss19.dto.theater;

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
public class TheaterDTO {

    private Long id;

    @NotBlank(message = "Tên rạp không được để trống")
    private String theaterName;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;

    @NotNull(message = "Số phòng chiếu không được để trống")
    @Min(value = 1, message = "Số phòng chiếu phải lớn hơn 0")
    private Integer numberScreenRoom;

    private boolean status;
}
