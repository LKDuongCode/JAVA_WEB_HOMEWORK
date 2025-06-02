package com.duong.ss16.dto.hw01;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class LoginUserDTO {
    @NotBlank(message = "email cannot be blank!")
    @Email(message = "invalid email!")
    private String email;

    @NotBlank(message = "password cannot be blank!")
    private String password;
}
