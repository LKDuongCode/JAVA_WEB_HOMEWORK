package com.duong.ss19.dto.movie;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private Long id;

    @NotBlank(message = "Tên phim không được để trống")
    private String title;

    @NotBlank(message = "Đạo diễn không được để trống")
    private String director;

    @NotNull(message = "Năm phát hành không được để trống")
    @Min(value = 1900, message = "Năm phát hành phải >= 1900")
    @Max(value = 2100, message = "Năm phát hành không hợp lệ")
    private Integer releaseYear;

    private String genre;

    @NotNull(message = "Thời lượng không được để trống")
    @Min(value = 1, message = "Thời lượng phải > 0")
    private Integer duration;

    private String language;

    @Pattern(regexp = "^(http|https)://.*$", message = "Ảnh poster phải là URL hợp lệ")
    private String poster;

    private boolean status;
}
