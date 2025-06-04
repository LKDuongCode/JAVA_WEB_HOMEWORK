package com.duong.ss18.dto.auth;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterAccDTO {
    private String username;
    private String password;
    private String email;
    private String phone;
}
