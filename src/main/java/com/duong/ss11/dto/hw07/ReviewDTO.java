package com.duong.ss11.dto.hw07;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    @NotBlank(message = "name cannot be blank!")
    private String name;

    @NotBlank(message = "email cannot be blank!")
    @Email(message = "email is invalid!")
    private String email;

    @Max(5)
    @Min(1)
    private int star;

    @Size(max = 10, message = "note exceeds maximum characters (10)")
    private String note;
}
