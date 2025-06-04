package com.duong.ss18.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductDTO {
    private int id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private MultipartFile imageFile;
}