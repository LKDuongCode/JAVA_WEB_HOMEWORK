package com.duong.ss20.dto;

import com.duong.ss20.validate.UniqueName;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@Setter
@Getter
public class CreateSeedDTO {

    @NotBlank(message = "name cannot be blank!")
    @Size(max = 100, message = "name must be maximum 100 characters!")
    @UniqueName (message = "name already exists!")
    private String name;


    private String description;

    @Min(value = 1, message = "price must be greater than 0!")
    private double price;

    @Min(value = 0,message = "stock must be greater than or equal to 0!")
    private int stock;


    private String image;

    private MultipartFile file;
}
