package com.duong.ss12.dto.hw02;

import com.duong.ss12.model.Product;
import com.duong.ss12.validate.hw02.ValidImage;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@NoArgsConstructor
public class CreateProductDTO {
    @NotBlank(message = "name cannot be blank!")
    @Size(max = 100, message = "name cannot be longer than 100 characters!")
    private String name;

    @Min(value = 1, message = "price must be greater than 0!")
    private double price;

    @Min(value = 1, message = "quantity must be greater than 0!")
    private int quantity;

    @ValidImage
    private MultipartFile image;

    private String filename;

    public CreateProductDTO(String name, double price, int quantity, String filename) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.filename = filename;
    }
}
