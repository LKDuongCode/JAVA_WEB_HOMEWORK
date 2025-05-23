package com.duong.ss11.dto.hw0809;

import com.duong.ss11.validate.hw0809.UniqueNameUpdate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@UniqueNameUpdate
@AllArgsConstructor
@NoArgsConstructor
public class CategoryUpdateDTO {

    @Min(1)
    private int id;

    @NotBlank(message = "name cannot be blank!")
    private String name;
}