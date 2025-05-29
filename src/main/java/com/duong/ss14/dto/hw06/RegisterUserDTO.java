package com.duong.ss14.dto.hw06;

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
public class RegisterUserDTO {

    @NotBlank(message = "{hw06.username.required}")
    @Size(min = 4, max = 20, message = "{hw06.username.size}")
    private String username;

    @NotBlank(message = "{hw06.password.required}")
    @Size(min = 6, message = "{hw06.password.size}")
    private String password;

    @NotBlank(message = "{hw06.confirmPassword.required}")
    private String confirmPassword;

    @NotBlank(message = "{hw06.email.required}")
    @Email(message = "{hw06.email.invalid}")
    private String email;
}