package com.duong.ss10.controller.hw06;

import com.duong.ss10.config.cloudinary.CloudinaryService;
import com.duong.ss10.model.UploadFile;
import com.duong.ss10.service.hw06.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class UploadController {
    private final CloudinaryService cloudinaryService;
    private final UploadFileService uploadFileService;

    public UploadController(CloudinaryService cloudinaryService,
                            UploadFileService uploadFileService) {
        this.cloudinaryService = cloudinaryService;
        this.uploadFileService = uploadFileService;
    }


    @GetMapping("/hw06")
    public String showUploadForm (Model model){
        if(!model.containsAttribute("file-hw06")){
            model.addAttribute("file-hw06",new UploadFile());
        }
        return "hw06_upload_form";
    }

    @PostMapping("/hw06-cloudinary")
    public String uploadFile (@ModelAttribute("file-hw06") UploadFile uploadFile, RedirectAttributes redirectAttributes){
        MultipartFile file = uploadFile.getFile();
        String des = uploadFile.getDes();

        if (file == null || file.isEmpty()) {
            redirectAttributes.addFlashAttribute("mes", "Please choose your file!");
            return "redirect:/hw06";
        }


        String url = cloudinaryService.uploadFile(file);
        if (url == null) {
            redirectAttributes.addFlashAttribute("mes", "Upload to Cloudinary failed!");
            return "redirect:/hw06";
        }


        Optional<UploadFile> saved = uploadFileService.addFileImage(new UploadFile(url, des));
        if (saved.isEmpty()) {
            redirectAttributes.addFlashAttribute("mes", "Save to DB failed!");
            return "redirect:/hw06";
        }


        redirectAttributes.addFlashAttribute("fileURL", url);
        redirectAttributes.addFlashAttribute("des", des);
        return "redirect:/hw06";

    }

}
