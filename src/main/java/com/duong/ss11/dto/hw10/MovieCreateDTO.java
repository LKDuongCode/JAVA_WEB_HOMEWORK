package com.duong.ss11.dto.hw10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieCreateDTO {
    private String title;
    private String director;
    private LocalDate releaseDate;
    private String genre;
    private String poster;
}