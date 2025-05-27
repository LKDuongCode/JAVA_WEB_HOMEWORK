package com.duong.ss12.dto.hw02;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductDTO {
    private int id;

    @NotBlank(message = "name cannot be blank!")
    private String name;

    @Min(value = 1, message = "price must be greater than 0!")
    private double price;

    @Min(value = 1, message = "quantity must be greater than 0!")
    private int quantity;

    private String image;

    private MultipartFile imageFile;

    public UpdateProductDTO(int id, String name, double price, int quantity, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }
}
