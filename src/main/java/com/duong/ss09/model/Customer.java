package com.duong.ss09.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private long id;
    private String username;
    private String phone;
    private String address;
    private String email;
    private Gender gender;
    private String password;
}
