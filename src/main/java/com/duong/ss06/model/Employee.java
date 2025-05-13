package com.duong.ss06.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    private String name;
    private Date birthday;
    private String phone;
    private String email;
    private BigDecimal salary;
    private String position;
    public Employee(String name, Date birthday, String phone, String email, BigDecimal salary, String position) {
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.position = position;
    }

}
