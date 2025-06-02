package com.duong.ss16.dto.hw01;

import com.duong.ss16.validate.hw01.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RegisterUserDTO {
    @NotBlank(message = "username cannot be blank!")
    private String username;
    @NotBlank(message = "email cannot be blank!")
    @Email(message = "invalid email!")
    @UniqueEmail
    private String email;

    @NotBlank(message = "password cannot be blank!")
    @Size(min = 3, message = "password must be 3 characters or more!")
    private String password;

}
