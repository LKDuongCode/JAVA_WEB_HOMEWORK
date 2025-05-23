package com.duong.ss11.dto.hw02;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {
    @NotBlank(message = "name cannot be blank!")
    private String name;

    @NotBlank(message = "email cannot be blank!")
    @Email(message = "email is not valid!")
    private String email;

    @NotBlank(message = "password cannot be blank!")
    @Size(min = 8, message = "password must be 8 characters or more!")
    private String password;
}
