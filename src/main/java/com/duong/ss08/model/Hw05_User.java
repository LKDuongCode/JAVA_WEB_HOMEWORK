package com.duong.ss08.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hw05_User {
    private String name;
    private int age;
    private LocalDate birthday;
    private String email;
    private String phone;
}
