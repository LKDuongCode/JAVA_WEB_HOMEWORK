package com.duong.ss11.controller.hw05;

import com.duong.ss11.dto.hw05.Role;
import com.duong.ss11.dto.hw05.UserDTO;
import com.duong.ss11.validate.hw05.AdminGroup;
import com.duong.ss11.validate.hw05.NormalGroup;
import jakarta.validation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class UserController {
    @GetMapping("/hw05")
    public String display (@ModelAttribute("userDTO")UserDTO userDTO){
        if (userDTO.getRole() == null) {
            userDTO.setRole(Role.NORMAL);
        }
        return "hw05_group_form";
    }

    @PostMapping("/hw05")
    public String register (@ModelAttribute("userDTO") UserDTO userDTO, Model model){
        Class<?> group = userDTO.getRole() == Role.ADMIN ? AdminGroup.class : NormalGroup.class;
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO, group);

            if (!violations.isEmpty()) {
                for (ConstraintViolation<UserDTO> violation : violations) {
                    model.addAttribute(violation.getPropertyPath().toString() + "Error", violation.getMessage());
                }
                return "hw05_group_form";
            }
        }
        return "hw05_result";
    }
}
