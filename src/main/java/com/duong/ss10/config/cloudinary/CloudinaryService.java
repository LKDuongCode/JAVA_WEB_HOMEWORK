package com.duong.ss10.config.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

@Service
public class CloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String uploadFile(MultipartFile multipartFile) {
        try {
            File tempFile = File.createTempFile("temp-", multipartFile.getOriginalFilename());
            multipartFile.transferTo(tempFile);

            @SuppressWarnings("unchecked")
            Map<String, Object> result = cloudinary.uploader().upload(
                    tempFile,
                    ObjectUtils.asMap(
                            "folder", "ss10",
                            "type", "upload"
                    )
            );


            return (String) result.get("secure_url");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
