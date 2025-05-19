package com.duong.ss10.controller.hw05;

import com.duong.ss10.model.Document;
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
public class DocumentController {

    @Autowired
    ServletContext servletContext;

    @GetMapping("/hw05-doc")
    public String showUploadForm(Model model) {
        if (!model.containsAttribute("document")) {
            model.addAttribute("document", new Document());
        }
        return "hw05_doc_form"; // view JSP
    }

    @PostMapping("/hw05-doc-upload")
    public String uploadDocument(@ModelAttribute("document") Document document,
                                 RedirectAttributes redirectAttributes) {

        MultipartFile file = document.getFile();

        if (file == null || file.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Vui lòng chọn file!");
            return "redirect:/hw05-doc";
        }

        try {
            String uploadDir = "D:/Learn/JavaWeb/ss10/src/main/webapp/uploads";

            File dir = new File(uploadDir);
            if (!dir.exists()) {
                boolean created = dir.mkdirs();
                if (!created) {
                    redirectAttributes.addFlashAttribute("errorMessage", "Không thể tạo thư mục để lưu file.");
                    return "redirect:/hw05-doc";
                }
            }

            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            file.transferTo(new File(uploadDir + File.separator + fileName));

            redirectAttributes.addFlashAttribute("message", "Upload thành công!");
            redirectAttributes.addFlashAttribute("uploadedFile", fileName);
            redirectAttributes.addFlashAttribute("title", document.getTitle());
            redirectAttributes.addFlashAttribute("description", document.getDescription());

        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi upload file!");
        }

        return "redirect:/hw05-doc";
    }
}