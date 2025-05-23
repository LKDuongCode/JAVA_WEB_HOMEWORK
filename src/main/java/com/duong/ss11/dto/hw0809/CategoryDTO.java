package com.duong.ss11.dto.hw0809;

import com.duong.ss11.validate.hw0809.UniqueNameCreate;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {
    @NotBlank(message = "Name must not be blank")
    @UniqueNameCreate
    private String name;
}
