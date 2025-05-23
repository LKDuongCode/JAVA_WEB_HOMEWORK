package com.duong.ss11.dto.hw06;

import com.duong.ss11.validate.hw06.ValidPhone;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
    @NotBlank(message = "phone cannot be blank!")
    @ValidPhone
    private String phone;
}
