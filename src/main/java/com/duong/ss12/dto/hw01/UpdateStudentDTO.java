package com.duong.ss12.dto.hw01;

import com.duong.ss12.validate.hw01.UniqueEmailUpdate;
import com.duong.ss12.validate.hw01.ValidDob;
import com.duong.ss12.validate.hw01.ValidFormatEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@UniqueEmailUpdate
public class UpdateStudentDTO {
    private int id;

    @NotBlank(message = "name cannot be blank!")
    @Size(max = 100, message = "name cannot be longer than 100 characters!")
    private String name;

    @NotBlank(message = "email cannot be blank!")
    @ValidFormatEmail
    private String email;

    @ValidDob
    private LocalDate dob;
}
