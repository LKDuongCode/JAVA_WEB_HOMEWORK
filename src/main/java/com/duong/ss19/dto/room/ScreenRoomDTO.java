package com.duong.ss19.dto.room;

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
public class ScreenRoomDTO {

    private Long id;

    @NotBlank(message = "Tên phòng không được để trống")
    private String roomName;

    @NotNull(message = "Sức chứa không được để trống")
    @Min(value = 1, message = "Sức chứa phải lớn hơn 0")
    private Integer capacity;

    @NotBlank(message = "Loại màn hình không được để trống")
    private String screenType;

    private boolean status;

    @NotNull(message = "Rạp chiếu không được để trống")
    private Long theaterId;

    private String theaterName;
}
