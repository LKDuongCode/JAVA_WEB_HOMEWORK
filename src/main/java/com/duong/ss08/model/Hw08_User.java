package com.duong.ss08.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Hw08_User {
    private int id;
    private String username;
    private String password;
    private String email;
    private double balance = 10000;
}