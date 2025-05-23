package com.duong.ss11.dto.hw05;

import com.duong.ss11.validate.hw05.AdminGroup;
import com.duong.ss11.validate.hw05.NormalGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @NotBlank(message = "username cannot be blank!", groups = {AdminGroup.class, NormalGroup.class})
    private String username;

    @NotBlank(message = "email cannot be blank!", groups = {AdminGroup.class, NormalGroup.class})
    @Email(message = "email is invalid!", groups = {AdminGroup.class, NormalGroup.class})
    private String email;

    private Role role;

    @NotBlank(message = "code cannot be blank!", groups = {AdminGroup.class})
    private String adminCode;
}
