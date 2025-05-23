package com.duong.ss11.dto.hw01;

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
public class InfoDTO {
    @NotBlank(message = "name cannot be blank!")
    @Size(min = 2, message = "name must be 2 characters or more!" )
    private String name;

    @NotBlank(message = "email cannot be blank!")
    @Email(message = "email is not valid!")
    private String email;

    @NotBlank(message = "phone cannot be blank!")
    @Size(min = 10, max = 11, message = "phone must be 10 to 11 numbers!")
    private String phone;

    @NotBlank(message = "password cannot be blank!")
    @Size (min = 3, message = "password must be 3 characters or more!")
    private String password;

    private boolean status;
}
