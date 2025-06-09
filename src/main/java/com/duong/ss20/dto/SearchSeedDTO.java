package com.duong.ss20.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SearchSeedDTO {
    private String name;
    private double min;
    private double max;
}
