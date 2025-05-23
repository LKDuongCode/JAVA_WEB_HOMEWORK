package com.duong.ss11.dto.hw03;

import com.duong.ss11.validate.hw03.ValidEmail;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hw03DTO {
    @NotBlank(message = "email cannot be blank!")
    @ValidEmail(message = "email is invalid!")
    private String email;
}
