package com.duong.ss12.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentLark {
    private String id;
    private String name;
    private String email;
    private String phone;
    private Sex sex;
    private LocalDateTime bod;
    private String avatar;
    private StudentStatus status;
}
