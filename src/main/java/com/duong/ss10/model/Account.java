package com.duong.ss10.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private int id;
    private String username;
    private String password;
    private String email;

    public Account(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
