package com.duong.ss12.dto.lark01;

import com.duong.ss12.model.Sex;
import com.duong.ss12.model.StudentStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentLarkDTO {

    @NotBlank(message = "ID cannot be blank!")
    @Size(max = 5, message = "ID cannot be longer than 5 characters!")
    private String id;

    @NotBlank(message = "Name cannot be blank!")
    @Size(max = 200, message = "Name cannot be longer than 200 characters!")
    private String name;

    @NotBlank(message = "Email cannot be blank!")
    @Email(message = "Email format is invalid!")
    private String email;

    @Size(max = 15, message = "Phone number cannot be longer than 15 characters!")
    private String phone;

    @NotNull(message = "Sex must be selected!")
    private Sex sex;

    @NotNull(message = "Birthdate must be selected!")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime bod;

    private MultipartFile avatarFile;

    private String avatar;

    @NotNull(message = "Status must be selected!")
    private StudentStatus status;
}
