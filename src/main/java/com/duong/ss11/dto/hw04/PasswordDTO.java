package com.duong.ss11.dto.hw04;

import com.duong.ss11.validate.hw04.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordDTO {
    @NotBlank(message = "password cannot be blank!")
    @ValidPassword
    private String password;
}
