package com.duong.ss10.controller.hw04;

import com.duong.ss10.config.cloudinary.CloudinaryService;
import com.duong.ss10.model.UserProfile;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class ProfileController {

    @Autowired
    ServletContext servletContext;

    @GetMapping("/hw04")
    public String gotoUploadForm(Model model) {
        if (!model.containsAttribute("user-profile")) {
            model.addAttribute("user-profile", new UserProfile());
        }
        return "hw04_up_file_form";
    }

    @PostMapping("/hw04-upload-server")
    public String uploadAvatar(@ModelAttribute("user-profile") UserProfile userProfile,
                               RedirectAttributes redirectAttributes) {
        MultipartFile file = userProfile.getAvatar();

        if (file == null || file.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Vui lòng chọn file!");
            return "redirect:/hw04";
        }


        try {
            String uploadDir = "D:/Learn/JavaWeb/ss10/src/main/webapp/uploads";

            File dir = new File(uploadDir);
            if (!dir.exists()) {
                boolean created = dir.mkdirs();
                if (!created) {
                    redirectAttributes.addFlashAttribute("errorMessage", "Không thể tạo thư mục để lưu file.");
                    return "redirect:/hw04";
                }
            }

            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            file.transferTo(new File(uploadDir + File.separator + fileName));

            redirectAttributes.addFlashAttribute("message", "Upload thành công!");
            redirectAttributes.addFlashAttribute("uploadedFile", fileName);
            redirectAttributes.addFlashAttribute("username", userProfile.getUsername());
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi upload file!");
        }

        return "redirect:/hw04";
    }

}